package com.my.app.localuser.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LocalUserDetail implements UserDetails {

	private static final long serialVersionUID = 2947892409954055034L;

	private LocalUser localUser;

	public LocalUserDetail(LocalUser localUser) {
		this.localUser = localUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return localUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public LocalUser getLocalUser() {
		return localUser;
	}

	public void setLocalUser(LocalUser localUser) {
		this.localUser = localUser;
	}

}
