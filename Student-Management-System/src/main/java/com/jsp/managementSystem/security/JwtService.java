package com.jsp.managementSystem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "pY3X+fK0ZpZ1zK0nQeYFq2b7Kz6y5y0R7mGxR8cZx9Q=";

    private static final long EXPIRY = 3600000; // 1 hour


    private SecretKey key() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }


    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRY))
                .signWith(key())
                .compact();
    }


    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }


    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
