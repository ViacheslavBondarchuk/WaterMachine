package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.*;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Log4j2
@Service
public class UserService implements UserDetailsService {
    private final QUser qUser = QUser.user;
    private UserRepository userRepository;
    private OwnerRepository ownerRepository;
    private MasterRepository masterRepository;
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();
    private JPAQueryFactory query;

    @Autowired
    public UserService(JPAQueryFactory query, UserRepository userRepository, OwnerRepository ownerRepository
            , MasterRepository masterRepository, SecurityInformation securityInformation) {
        this.query = query;
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
        this.masterRepository = masterRepository;
        this.securityInformation = securityInformation;
    }

    public void addUser(UserDTO userDTO) {
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userDTO.setEnabled(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);
        userDTO.setAuthorities(Collections.singleton(Authority.USER));

        if (userDTO.isOwner()) {
            ownerRepository.save(modelMapper.map(userDTO, Owner.class));
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else if (userDTO.isMaster()) {
            masterRepository.save(modelMapper.map(userDTO, Master.class));
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            userRepository.save(modelMapper.map(userDTO, User.class));
        }
        log.debug("User was added");
    }

    public void updateUser(final UserDTO userDTO) {
        User user = query.selectFrom(qUser).where(qUser.id.eq(userDTO.getId())
                .and(qUser.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();

        if (user == null) {
            throw new UsernameNotFoundException("User has been not found");
        }
        log.debug("User has been updated");
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public User getUserById(final long id) {
        return query.selectFrom(qUser).where(qUser.id.eq(id)
                .and(qUser.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
    }

    public List<User> getAllByCompanyId() {
        return userRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public void deleteUserById(final long id) {
        query.delete(qUser)
                .where(qUser.id.eq(id)
                        .and(qUser.companyId.eq(securityInformation.getUserCompanyId()))).execute();
        log.debug("User was deleted");
    }


    //    Method from interface'UserDetailsService'
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User by %s has been not found", username)));
    }

}
