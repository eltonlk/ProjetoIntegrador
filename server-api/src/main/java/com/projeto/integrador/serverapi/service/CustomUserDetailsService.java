package com.projeto.integrador.serverapi.service;

import java.util.Collection;

import com.projeto.integrador.serverapi.model.User;
import com.projeto.integrador.serverapi.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UsersRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);

    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      getAuthorities(user)
    );
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
    String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);

    Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);

    return authorities;
  }

}
