package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByRole(Role role); // tüm müşterileri döndürmek için findAllByRole(Role.CUSTOMER) kullanılacak
}
