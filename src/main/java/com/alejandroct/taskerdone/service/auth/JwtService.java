package com.alejandroct.taskerdone.service.auth;

import com.alejandroct.taskerdone.model.User;
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

    @Value("${jwt.secret.key}")
    private String secretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey));
    }

    public String buildToken(User user){
        return Jwts.builder()
                .claims(Map.of("id", user.getId(),"name", user.getName()))
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+this.tokenExpiration))
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

    /**
     * Return the token from the AuthHeader
     * or null if not Bearer
     * @param authorizationHeader
     * @return token || null
     */
    private String getAuthorizationToken(String authorizationHeader){
        if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
            return authorizationHeader.substring(7);
        }
        return null;
    }

    public Long getUserIdFromToken(String authorizationHeader){
        String token = getAuthorizationToken(authorizationHeader);
        Claims claims = getAllClaims(token);
        return ((Number) claims.get("id")).longValue();
    }

}
