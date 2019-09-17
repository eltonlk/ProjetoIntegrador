package com.projeto.integrador.clientdesktop.config;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    if ("admin".equals(username) && "123456789".equals(password)) {
      // if (true) {
        // Collection<? extends GrantedAuthority> authorities = usuarioBd.getPapeis();

        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
      // } else {
      //   throw new BadCredentialsException("Este usuário está desativado.");
      // }
    } else {
      throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }
  }

}
