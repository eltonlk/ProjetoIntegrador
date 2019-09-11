package com.projeto.integrador.serverapi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.projeto.integrador.serverapi.model.Privilege;
import com.projeto.integrador.serverapi.model.Role;
import com.projeto.integrador.serverapi.model.User;
import com.projeto.integrador.serverapi.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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

  private static Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    return getGrantedAuthorities(getPrivileges(roles));
  }

  private List<String> getPrivileges(Collection<Role> roles) {
    List<String> privileges = new ArrayList<>();
    List<Privilege> collection = new ArrayList<>();

    for (Role role : roles) {
      collection.addAll(role.getPrivileges());
    }

    for (Privilege privilege : collection) {
      privileges.add(privilege.getName());
    }

    return privileges;
  }

  private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
    List<GrantedAuthority> authorities = new ArrayList<>();

    for (String privilege : privileges) {
      authorities.add(new SimpleGrantedAuthority(privilege));
    }

    return authorities;
  }

}
