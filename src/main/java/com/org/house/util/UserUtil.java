package com.org.house.util;

import com.org.house.dto.UserDTO;
import com.org.house.dto.UserMasterDTO;
import com.org.house.dto.UserOwnerDTO;
import com.org.house.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public final class UserUtil {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUser(UserDTO userDTO) {
        return new User().builder()
                .username(userDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .companyId(userDTO.getCompanyId())
                .email(userDTO.getEmail())
                .authorities(Collections.singleton(Authority.USER))
                .type(UserType.USER)
                .masters(null)
                .owners(null)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .isCredentialsNonExpired(true)
                .build();

    }

    public User getMaster(UserMasterDTO userMasterDTO) {
        Master master = Master.builder()
                .user_id(userMasterDTO.getId())
                .companyId(userMasterDTO.getCompanyId())
                .username(userMasterDTO.getUsername())
                .firstName(userMasterDTO.getFirstName())
                .lastName(userMasterDTO.getLastName())
                .automatons(null)
                .build();

        return new User().builder()
                .username(userMasterDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(userMasterDTO.getPassword()))
                .companyId(userMasterDTO.getCompanyId())
                .email(userMasterDTO.getEmail())
                .authorities(Collections.singleton(Authority.MASTER))
                .type(UserType.MASTER)
                .masters(master)
                .owners(null)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .isCredentialsNonExpired(true)
                .build();
    }

    public User getOwner(UserOwnerDTO userOwnerDTO) {
        Owner owner = Owner.builder()
                .user_id(userOwnerDTO.getId())
                .username(userOwnerDTO.getUsername())
                .firstName(userOwnerDTO.getFirstName())
                .lastName(userOwnerDTO.getLastName())
                .company(null)
                .build();

        return new User().builder()
                .username(userOwnerDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(userOwnerDTO.getPassword()))
                .companyId(userOwnerDTO.getCompanyId())
                .email(userOwnerDTO.getEmail())
                .authorities(Collections.singleton(Authority.OWNER))
                .type(UserType.OWNER)
                .masters(null)
                .owners(owner)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .isCredentialsNonExpired(true)
                .build();
    }
}
