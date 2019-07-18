package com.org.house.security;

import com.org.house.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public final class SecurityInformation {

    @Autowired
    private static UserRepository userRepository;

    private UserDetails securityContextHolder() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }


    private String usernameFromContext() {
        return securityContextHolder().getUsername();
    }


    public final long getUserCompanyId() {
        return userRepository.findByUsername(usernameFromContext())
                .orElseThrow(() -> new UsernameNotFoundException("User has been not found")).getCompanyId();
    }

}
