package com.projeto.integrador.serverapi.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.projeto.integrador.serverapi.jwt.service.TokenAuthenticationService;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

  public JWTLoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));

    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws AuthenticationException, IOException, ServletException {
    UserCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

    return getAuthenticationManager().authenticate(
      new UsernamePasswordAuthenticationToken(
        credentials.getUsername(),
        credentials.getPassword()
      )
    );
  }

  @Override
  protected void successfulAuthentication(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain,
    Authentication auth
  ) throws IOException, ServletException {
    TokenAuthenticationService.addAuthentication(response, auth);
  }

}
