package com.lcs.tele.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserBean implements UserDetails{
	private static final long serialVersionUID = 1L;

	private long id;
	private String username;
	private String password;
	private boolean enabled;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserBean(String username,String password,boolean enabled){
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public UserBean(String username,String password,boolean enabled,Collection<? extends GrantedAuthority> authorities){
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
		return enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
