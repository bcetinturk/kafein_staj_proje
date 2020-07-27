package com.example.kafein_staj.service.order;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.OrderProduct;
import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.OrderProductRepository;
import com.example.kafein_staj.repository.OrderRepository;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.LongFunction;
@Service
public class DefaultOrderService implements OrderService {
   private OrderRepository orderRepository;
   private UserRepository userRepository;
   private OrderProductRepository orderProductRepository;
    @Autowired
    public DefaultOrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public Order findById(Long order_id) throws EntityNotFoundException {
        return orderRepository.findById(order_id).orElseThrow(
                () -> new EntityNotFoundException("Order with id " + order_id + " does not exist"));

    }



    @Override
    public void deleteById(Long order_id) throws EntityNotFoundException {
        try {
            orderRepository.deleteById(order_id);

        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Order with "+order_id+" has already been deleted");
        }
    }

    @Override
    public List<Order> getAllOrdersByCustomer(Long customer_id) throws EntityNotFoundException {
        List<Order> orders = orderRepository.findAllByUser_Id(customer_id);
        if(orders.size() == 0) {
            throw new EntityNotFoundException("Customer has no orders");
        } else {
            return orders;
        }
    }

    @Override
    public List<OrderProduct> getAllProducts(Long order_id) throws EntityNotFoundException {
        List<OrderProduct> products = orderProductRepository.findAllByOrder_OrderId(order_id);
        if(products.size() == 0) {
            throw new EntityNotFoundException("Order does not exist");
        } else {
            return products;
        }

    }

    @Override
    public void changeQuantity(Order order) {
        int amount;
        List<OrderProduct> productsList;
        productsList=order.getProducts();
        HashMap<Product, Integer> productHaspMap = new HashMap<>();
       for(OrderProduct products: productsList){
           if(!productHaspMap.containsKey(products.getProduct())){
            productHaspMap.put(products.getProduct(),1);
       }else{
               amount=productHaspMap.get(products.getProduct());
               productHaspMap.put(products.getProduct(),amount+1);
            }

       }
       int quantity;
        for (Map.Entry<Product,Integer> entry: productHaspMap.entrySet()){
            Product p=entry.getKey();
            quantity=entry.getValue();
            int newAmount=p.getQuantity()-quantity;
            p.setQuantity(newAmount);
     }
    }

    @Override
    public void updateOrderStatus(Order order,String newStatus) throws EntityNotFoundException {
        long order_id=order.getOrderId();
        if(orderRepository.findById(order_id).isPresent()){
           if(newStatus.equals("Kargoya verildi")){
               changeQuantity(order);
               order.setStatus(newStatus);
           }else{
               order.setStatus(newStatus);
           }
        }else
        {
            throw new EntityNotFoundException("Order with "+ order_id+ "does not exists");
        }
    }

    @Override
    public void cancelledOrder(Order order) throws EntityNotFoundException {
        String orderStatus=order.getStatus();
        if( orderRepository.existsById(order.getOrderId())){
        if(orderStatus.equals("Sipariş Hazırlanıyor") ){
           this.deleteById(order.getOrderId());
        }
     }else{
            throw new EntityNotFoundException("order with "+order.getOrderId()+" does not exists");

        }
    }

}
