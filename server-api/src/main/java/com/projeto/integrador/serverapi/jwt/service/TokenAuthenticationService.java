package com.projeto.integrador.serverapi.jwt.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

public class TokenAuthenticationService {

  private static final long EXPIRATION_TIME = 864000000;
  private static final String SECRET = "MySecreteApp";
  private static final String TOKEN_PREFIX = "Bearer";
  private static final String HEADER_STRING = "Authorization";

  public static void addAuthentication(HttpServletResponse res, Authentication auth) {
    String JWT = Jwts.builder()
      .setSubject(auth.getName())
      .signWith(SignatureAlgorithm.HS256, SECRET)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .compact();

    String token = TOKEN_PREFIX + " " + JWT;

    res.addHeader(HEADER_STRING, token);

    try {
      res.getOutputStream().print(token);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getUsername(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);

    try {
      return Jwts.parser()
        .setSigningKey(SECRET)
        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
        .getBody()
        .getSubject();
    } catch (Exception e) {
      e.printStackTrace();

      return null;
    }
  }

}
