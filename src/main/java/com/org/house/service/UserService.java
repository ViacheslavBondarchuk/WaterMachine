package com.org.house.service;

import com.org.house.model.User;
import com.org.house.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		log.info("User was created");
		return userRepository.save(user);
	}
	
	public List<User> getAllUser() {
		log.info("Users was gotten");
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		userRepository.findById(user.getId()).ifPresent(user1 -> user.setId(user1.getId()));
		return userRepository.saveAndFlush(user);
	}

	public void deleteUser(long id) {
		log.info("User: " + id + "was deleted");
		userRepository.deleteById(id);

	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User: " + username + "has been not found"));
	}
}
