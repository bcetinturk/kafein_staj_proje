package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByRole(Role role); // tüm müşterileri döndürmek için findAllByRole(Role.CUSTOMER) kullanılacak
    Optional<User> findByEmail(String email);
    Integer countByRole(Role role);
}
