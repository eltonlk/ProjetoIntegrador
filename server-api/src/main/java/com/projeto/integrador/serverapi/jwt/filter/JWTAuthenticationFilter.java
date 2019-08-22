package com.projeto.integrador.serverapi.jwt.filter;

import com.projeto.integrador.serverapi.jwt.service.TokenAuthenticationService;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends GenericFilterBean {

  @Autowired
  private UserDetailsService userDetailsService;

  public JWTAuthenticationFilter(UserDetailsService userDetailsService) {
    super();

    setUserDetailsService(userDetailsService);
  }

  public void setUserDetailsService(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  public void doFilter(
    ServletRequest request,
    ServletResponse response,
    FilterChain chain
  ) throws IOException, ServletException {
    UsernamePasswordAuthenticationToken authentication = null;

    String username = TokenAuthenticationService.getUsername((HttpServletRequest) request);

    try {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      authentication = new UsernamePasswordAuthenticationToken(
        userDetails.getUsername(),
        userDetails.getPassword(),
        userDetails.getAuthorities()
      );
    } catch (Exception e) {
      e.printStackTrace();
    }

    SecurityContextHolder.getContext().setAuthentication(authentication);

    chain.doFilter(request, response);
  }

}
