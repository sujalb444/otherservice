package com.mopa.pacc.pmis.security;

 
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;

        @Component
        public class JwtProvider {
            @Value("${app.jwtSecret}")
            private String jwtSecret;
            @Value("${app.jwtExpirationInMs}")
            private int jwtExpirationInMs;

            public String generateToken(Authentication authentication) {
                UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
                Date now = new Date();
                Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

                return Jwts.builder()
                    .setSubject(userPrincipal.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
            }
            public String getUserUsernameFromJWT(String token) {
                Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
                return claims.getSubject();
            }
            public boolean validateToken(String authToken) {
                try {
                    Jwts.parser()
                        .setSigningKey(jwtSecret)
                        .parseClaimsJws(authToken);
                    return true;
                } catch (SignatureException ex) {
                } catch (MalformedJwtException ex) {
                } catch (ExpiredJwtException ex) {
                } catch (UnsupportedJwtException ex) {
                } catch (IllegalArgumentException ex) {
                }
                return false;
            }
        }
    

