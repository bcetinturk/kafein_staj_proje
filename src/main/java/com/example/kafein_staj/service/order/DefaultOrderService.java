package com.example.kafein_staj.service.order;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.*;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.repository.*;
import com.example.kafein_staj.utils.PrincipalUtil;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.LongFunction;

@Service
public class DefaultOrderService implements OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderProductRepository orderProductRepository;
    private ProductRepository productRepository;
    private BasketProductRepository basketProductRepository;
    private PrincipalUtil principalUtil;

    @Autowired
    public DefaultOrderService(
            OrderRepository orderRepository,
            OrderProductRepository orderProductRepository,
            UserRepository userRepository,
            ProductRepository productRepository,
            BasketProductRepository basketProductRepository,
            PrincipalUtil principalUtil) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.basketProductRepository = basketProductRepository;
        this.principalUtil = principalUtil;
    }

    @Override
    public Order findById(Long order_id) throws EntityNotFoundException, IllegalOperationException {
        Long userId = principalUtil.getPrincipalId();

        Order order = orderRepository.findById(order_id).orElseThrow(
                () -> new EntityNotFoundException("Order with id " + order_id + " does not exist"));

        //siparişi görüntülemek isteyen kişi ile siparişi veren kişi aynı mı?
        if ( !(order.getUser().getId().equals(userId)) ) {
            throw new IllegalOperationException("Order's user id does not match");
        }

        return order;
    }


    @Override
    public void deleteById(Long order_id) throws EntityNotFoundException, IllegalOperationException  {
        findById(order_id);
        orderRepository.deleteById(order_id);
    }

    @Override
    public List<Order> getAllOrdersByCustomer(Long customer_id) throws EntityNotFoundException {
        List<Order> orders = orderRepository.findAllByUser_Id(customer_id);
        if (orders.size() == 0) {
            throw new EntityNotFoundException("Customer has no orders");
        } else {
            return orders;
        }
    }

    @Override
    public List<OrderProduct> getAllProducts(Long order_id) throws EntityNotFoundException {
        List<OrderProduct> products = orderProductRepository.findAllByOrder_OrderId(order_id);
        if (products.size() == 0) {
            throw new EntityNotFoundException("Order does not exist");
        } else {
            return products;
        }

    }

    @Override
    public void changeQuantity(Order order) {

        List<OrderProduct> productList = order.getProducts();
        for(OrderProduct orderProduct: productList) {
            int currentQuantity = orderProduct.getProduct().getQuantity();
            int orderQuantity = orderProduct.getAmount();
            Product product = orderProduct.getProduct();
            product.setQuantity(currentQuantity - orderQuantity);
            productRepository.save(product);
        }
    }

    @Override
    public Order updateOrderStatus(Long order_id, OrderDTO orderDto) throws EntityNotFoundException, IllegalOperationException {
        Order order = orderRepository.findById(order_id).orElseThrow(
                () -> new EntityNotFoundException(""));

        String newStatus = orderDto.getStatus();
        if(newStatus.equals("Shipped") && order.getStatus().equals("Preparing")) {
            order.setStatus("Shipped");
            changeQuantity(order);
        } else if(newStatus.equals("Delivered") && order.getStatus().equals("Shipped")) {
            order.setStatus("Delivered");
        } else if(newStatus.equals("Cancelled") && order.getStatus().equals("Preparing")) {
            order.setStatus("Cancelled");
        } else {
            throw new IllegalOperationException("Can't update status");
        }

        return orderRepository.save(order);
    }

    @Override
    public void cancelledOrder(Long orderId) throws EntityNotFoundException, IllegalOperationException {
        Order order = findById(orderId);
        if( order.getStatus().equals("Preparing") ) {
            order.setStatus("Cancelled");
            orderRepository.save(order);
        } else {
            throw new IllegalOperationException("");
        }
    }


    @Override
    @Transactional
    public Order newOrder() throws EntityNotFoundException {
        Long userId = principalUtil.getPrincipalId();
        // 1.  Get user
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(""));
        // 2.  Get user's basket
        Basket basket = user.getBasket();
        // 3.  Get all products in basket (get price amount name)
        List<BasketProduct> products = basket.getProducts();
        // 4.  Create new order
        Order order = new Order();
        // 5.  Set destination (user address)
        order.setDestination(user.getAddress());
        // 6.  calculate total
        long total = 0;
        for (BasketProduct basketProduct : products) {
            total += basketProduct.getProduct().getPrice() * basketProduct.getAmount();
        }
        order.setTotalPrice(total);
        // 7.  Set status
        order.setStatus("Preparing");
        // 8.  Set user id
        order.setUser(user);
        // 9. Set orderNo
        order.setOrderNo(UUID.randomUUID());
        // 10. Save order
        order = orderRepository.save(order);
        // 11.  For each product from basket create new OrderProduct
        // 12. Set orderId for OrderProducts
        // 13. Save OrderProduct
        for (BasketProduct basketProduct : products) {
            OrderProduct orderProduct = new OrderProduct();

            orderProduct.setAmount(basketProduct.getAmount());
            orderProduct.setProduct(basketProduct.getProduct());
            orderProduct.setOrder(order);

            orderProductRepository.save(orderProduct);
            basketProductRepository.deleteById(basketProduct.getId());
        }

        return order;
    }
}
