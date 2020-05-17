package com.act4new.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.act4new.backend.model.Users;
import com.act4new.backend.dao.UserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDAO userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
//	public UserDetails loadUserByUsername(String username) 
//			  throws UsernameNotFoundException {
//			  
//			    boolean enabled = true;
//			    boolean accountNonExpired = true;
//			    boolean credentialsNonExpired = true;
//			    boolean accountNonLocked = true;
//			    try {
//			    	User user = userRepository.findByUsername(username)
//							.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//			         
//			        return new org.springframework.security.core.userdetails.User(
//			          user.getUsername(), 
//			          user.getPassword().toLowerCase(), 
//			          user.isEnabled(), 
//			          accountNonExpired, 
//			          credentialsNonExpired, 
//			          accountNonLocked, null);
//			    } catch (Exception e) {
//			        throw new RuntimeException(e);
//			    }
//			}
	

	

	

	





		}
