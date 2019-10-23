package com.robsoft.agenda.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.robsoft.agenda.converters.UserConverter;
import com.robsoft.agenda.entities.UserRole;
import com.robsoft.agenda.repositories.UserRepository;
import com.robsoft.agenda.repositories.UserRoleRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.robsoft.agenda.entities.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	private User buildUser(com.robsoft.agenda.entities.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for (UserRole role : userRoles) {
			auths.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
	
	public com.robsoft.agenda.models.User store(com.robsoft.agenda.models.User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		com.robsoft.agenda.entities.User userEntity = userConverter.toEntity(user);
		com.robsoft.agenda.entities.User userCreated = userRepository.save(userEntity);
		userRoleRepository.save(new UserRole(userCreated, "admin"));
		return userConverter.toModel(userCreated);
	}

	public com.robsoft.agenda.models.User find(String username) {
		return userConverter.toModel(userRepository.findByUsername(username));
	}
}
