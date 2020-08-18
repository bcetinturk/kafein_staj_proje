package com.example.kafein_staj.utils;

import com.example.kafein_staj.entity.UserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PrincipalUtil {
    public Long getPrincipalId() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    public ArrayList<GrantedAuthority> getAuthorities() {
        return new ArrayList<>(
                SecurityContextHolder.getContext().getAuthentication().getAuthorities()
        );
    }
}
