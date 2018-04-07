package com.my.app.localuser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.my.app.localuser.domain.LocalUser;
import com.my.app.localuser.domain.LocalUserDetail;

public class LocalUserService implements UserDetailsService {

	private static final Logger L = LoggerFactory.getLogger(LocalUserService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		L.info("username: {}", username);

		LocalUser localUser = new LocalUser();
		localUser.setUsername(username);
		localUser.setPassword("admin");

		return new LocalUserDetail(localUser);
	}

}
