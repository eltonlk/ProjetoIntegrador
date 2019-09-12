package com.projeto.integrador.serverapi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.projeto.integrador.serverapi.model.Role;
import com.projeto.integrador.serverapi.model.User;
import com.projeto.integrador.serverapi.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
      user.isActive(),
      true,
      true,
      true,
      getAuthorities(user.getRoles())
    );
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();

    for (Role role: roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));

      role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).forEach(authorities::add);
    }

    return authorities;
  }

}
