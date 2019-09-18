package com.projeto.integrador.clientdesktop.config;

import java.util.Collections;

import com.projeto.integrador.clientdesktop.models.TokenCredential;
import com.projeto.integrador.clientdesktop.models.UserCredential;
import com.projeto.integrador.clientdesktop.resources.SessionResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

  @Autowired
  private SessionResource sessionResource;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserCredential userCredential = new UserCredential(authentication.getName(), authentication.getCredentials().toString());

    try {
      TokenCredential tokenCredential = sessionResource.requestToken(userCredential);

      return new UsernamePasswordAuthenticationToken(tokenCredential, userCredential, Collections.emptyList());
    } catch (Exception e) {
      e.printStackTrace();

      throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }
  }

}
