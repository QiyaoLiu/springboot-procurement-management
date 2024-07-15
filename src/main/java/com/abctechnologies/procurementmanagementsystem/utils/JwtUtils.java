package com.abctechnologies.procurementmanagementsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static Key key = Keys.hmacShaKeyFor("abctechnologiesabctechnologiesabctechnologies".getBytes());

    /**
     * Generate GWT
     * @param claims JWT payload
     * @return
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        return jwt;
    }

    /**
     * ParseJWT
     * @param jwt JWT
     * @return JWT
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
