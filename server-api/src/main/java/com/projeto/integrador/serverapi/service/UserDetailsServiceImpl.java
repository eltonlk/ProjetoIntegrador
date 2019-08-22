package com.projeto.integrador.serverapi.service;

import java.util.HashSet;
import java.util.Set;

import com.projeto.integrador.serverapi.model.Role;
import com.projeto.integrador.serverapi.model.User;
import com.projeto.integrador.serverapi.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    for (Role role : user.getRoles()){
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      grantedAuthorities
    );
	}

}
