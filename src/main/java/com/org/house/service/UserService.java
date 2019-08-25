package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.Authority;
import com.org.house.model.QUser;
import com.org.house.model.User;
import com.org.house.model.UserType;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import com.org.house.security.SecurityInformation;
import com.org.house.util.UserUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
    private JPAQueryFactory query;
    @Autowired
    private SecurityInformation securityInformation;
    @Autowired
    private UserUtil userUtil;

    @Autowired
    public UserService(JPAQueryFactory query, UserRepository userRepository, OwnerRepository ownerRepository
            , MasterRepository masterRepository) {
        this.query = query;
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
        this.masterRepository = masterRepository;
    }

    public void addUser(UserDTO userDTO) {
        userRepository.save(userUtil.getUser(userDTO));
    }

    public void updateUser(final UserDTO userDTO) {
        userRepository.save(userUtil.getUser(userDTO));
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
    }


    @PostConstruct
    public void commandLineRunner() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setCompanyId(1);
        user.setEmail("slava.777.bondarchuk@outlook.com");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setType(UserType.USER);
        user.setCredentialsNonExpired(true);
        user.setAuthorities(Collections.singleton(Authority.ADMIN));
        user.setEnabled(true);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user has been not found"));

    }

}
