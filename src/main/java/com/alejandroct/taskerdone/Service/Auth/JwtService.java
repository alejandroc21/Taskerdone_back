package com.alejandroct.taskerdone.Service.Auth;

import com.alejandroct.taskerdone.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${token.expiration}")
    private long tokenExpiration;

    @Value("${jwt.secret.key")
    private String secretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey));
    }

    public String buildToken(User user){
        return Jwts.builder()
                .id(String.valueOf(user.getId()))
                .claims(Map.of("name", user.getName()))
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+tokenExpiration))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean isTokenValid(String token, User user){
        String username = extractUsername(token);
        return (username.equals(user.getEmail())) && !isTokenExpired(token);
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsResolver){
        Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token){
        return getClaims(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token){
        return getClaims(token, Claims::getExpiration).before(new Date());
    }


}
