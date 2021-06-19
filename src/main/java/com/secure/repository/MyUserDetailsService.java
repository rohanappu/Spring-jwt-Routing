package com.secure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.dao.Login;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	LoginRepository repo;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Login log=repo.findByUsername(arg0);
		return new LoginPrincipal(log);
	}

}
