package com.org.house.security;

import com.org.house.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public final class SecurityInformation {
    @Autowired
    private UserRepository userRepository;

    private String getUsername(){
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return username;
    }

    public long getUserCompanyId(){
        return userRepository.findByUsername(getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("User has been not found")).getCompanyId();
    }
}
