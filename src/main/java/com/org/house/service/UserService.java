package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.*;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final QUser qUser = QUser.user;
    private UserRepository userRepository;
    private OwnerRepository ownerRepository;
    private MasterRepository masterRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private JPAQueryFactory query;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(JPAQueryFactory query, UserRepository userRepository, OwnerRepository ownerRepository
            , MasterRepository masterRepository) {
        this.query = query;
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
        this.masterRepository = masterRepository;
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
    }

    public void updateUser(final UserDTO userDTO) {
        User user = query.selectFrom(qUser).where(qUser.id.eq(userDTO.getId())
                .and(qUser.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();

        if (user == null) {
            throw new UsernameNotFoundException("User has been not found");
        }
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public User getUserById(final long id) {
        return query.selectFrom(qUser).where(qUser.id.eq(id)
                .and(qUser.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();
    }

    public List<User> getAllByCompanyId() {
        return userRepository.findByCompanyId(SecurityInformation.getUserCompanyId());
    }

    public void deleteUserById(final long id) {
        query.delete(qUser)
                .where(qUser.id.eq(id)
                        .and(qUser.companyId.eq(SecurityInformation.getUserCompanyId()))).execute();
    }


    @PostConstruct
    public void commandLineRunner() {
        User user = new User();
        user.setUsername("user");
        user.setPassword(new BCryptPasswordEncoder().encode("user"));
        user.setCompanyId(1);
        user.setEmail("slava.777.bondarchuk@outlook.com");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setAuthorities(Collections.singleton(Authority.ADMIN));
        user.setMaster(false);
        user.setOwner(false);
        user.setEnabled(true);


        userRepository.save(user);
    }

    //    Method from interface'UserDetailsService'
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user has been not found"));

    }

}
