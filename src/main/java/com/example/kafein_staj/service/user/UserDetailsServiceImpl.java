package com.example.kafein_staj.service.user;

import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("In loadUserByUsername");
        User user = userRepository.findByEmail(s).orElseThrow(()->
                new UsernameNotFoundException("User not found"));

        System.out.println("User found");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        System.out.println("Granted authorities");
        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), authorities);

        System.out.println("Created user details");
        return userDetails;
    }
}
