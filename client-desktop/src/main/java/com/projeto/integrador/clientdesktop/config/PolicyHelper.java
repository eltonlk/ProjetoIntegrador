package com.projeto.integrador.clientdesktop.config;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class PolicyHelper {

  public Boolean can(String policy) {
    if (SecurityContextHolder.getContext().getAuthentication() != null &&
      SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

      Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();

      Collection<? extends GrantedAuthority> authorities = currentAuth.getAuthorities();

      return authorities.contains(new SimpleGrantedAuthority(policy));
    }

    return Boolean.FALSE;
  }

  public Boolean cannot(String policy) {
    return ! can(policy);
  }

}
