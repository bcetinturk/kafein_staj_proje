package com.example.kafein_staj.service.user;

import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.entity.UserDetailsImpl;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).orElseThrow(()->
                new UsernameNotFoundException("User not found"));

        UserDetailsImpl userDetails = new UserDetailsImpl(user);

        System.out.println("Created user details" + userDetails);
        return userDetails;
    }
}
