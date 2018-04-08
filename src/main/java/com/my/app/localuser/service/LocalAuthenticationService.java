package com.my.app.localuser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.app.localuser.domain.LocalUserDetail;

public class LocalAuthenticationService implements AuthenticationProvider {

	private static final Logger L = LoggerFactory.getLogger(LocalAuthenticationService.class);

	private Map<String, UserDetails> userCache = new ConcurrentHashMap<>();

	@Autowired
	private LocalUserService localUserService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Object principal = authentication.getPrincipal();
		if (principal instanceof LocalUserDetail) {
			UserDetails user = (LocalUserDetail) principal;
			return new UsernamePasswordAuthenticationToken(user, user.getPassword());
		}

		UsernamePasswordAuthenticationToken toekn = (UsernamePasswordAuthenticationToken) authentication;
		String username = toekn.getName();

		UserDetails user = this.userCache.get(username);

		if (user == null) {
			String password = toekn.getCredentials().toString();
			L.info("username: {}, password: {}", username, password);

			user = localUserService.loadUserByUsername(username);

			if (user == null) {
			}

			this.userCache.put(username, user);
		}

		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), getAuthorities());
	}

	private List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
