package com.yega.mlc.security;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yega.mlc.constants.JwtConstants;
import com.yega.mlc.dto.UserDetailsDTO;
import com.yega.mlc.exception.utils.UtilsEx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String PATTERN_JWT = "^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$";
    
    @Value("${secret_jwt_seed}")
    private String secretKey;

    @Value("${session_timeout}")
    private int expirationTime;

    @Cacheable(value = "cacheSessionToken", key = "#userDetails.getUsername()")
    public String createToken(UserDetails userDetails) {
        var loginRequestDTO = (UserDetailsDTO) userDetails;
        return engineToken(loginRequestDTO);
    }

    boolean validateToken(String token, UserDetails userDetails, String tokenInCache) {
        return isUserTokenValid(token, userDetails) && !hasTokenExpired(token) && isTheSameToken(token, tokenInCache);
    }

    @CacheEvict(value = "cacheSessionToken", key = "#userDetails.getUsername()")
    public void deleteToken(UserDetails userDetails) {
    }

    String extractUsername(String token) {
        return JWT.decode(token).getSubject();
    }

    Date extractExpiresAt(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    Collection<GrantedAuthority> getAuthorities(String token) {
        return JWT.decode(token).getClaim(JwtConstants.AUTHORITIES).asList(GrantedAuthority.class);
    }    

    boolean isValidPattern(String token){
        token = token != null ? token : "";
        Pattern r = Pattern.compile(PATTERN_JWT);
        Matcher m = r.matcher(token);        
        String[] parts = token.split("\\.");
        return m.matches() && parts.length == 3;
    }    

    private String engineToken(UserDetails userDetails) {
        var loginRequestDTO = (UserDetailsDTO) userDetails;
        String username = loginRequestDTO.getUsername();
        Collection<? extends GrantedAuthority> authorities = loginRequestDTO.getAuthorities();
        List<String> listAuthorities = authorities.stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        var cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expirationTime);

        return JWT.create().withSubject(username).withClaim(JwtConstants.AUTHORITIES, listAuthorities)
                .withIssuer(loginRequestDTO.getUsuarioAcceso().getUsuarioId().toString()).withExpiresAt(cal.getTime())
                .sign(getAlgorithm());
    }

    private boolean hasTokenExpired(String token) {
        try {
            return JWT.require(getAlgorithm()).build().verify(token).getExpiresAt().before(new Date());
        } catch (JWTVerificationException e) {
            UtilsEx.showStackTraceError(e);
            return false;
        }
    }

    private boolean isUserTokenValid(String token, UserDetails userDetails) {
        try {
            return JWT.require(getAlgorithm()).build().verify(token).getSubject().equals(userDetails.getUsername());
        } catch (JWTVerificationException e) {
            UtilsEx.showStackTraceError(e);
            return false;
        }
    }

    private boolean isTheSameToken(String token, String tokenRequest) {
        try {
            return JWT.require(getAlgorithm()).build().verify(token).getToken().equals(tokenRequest);
        } catch (JWTVerificationException e) {
            UtilsEx.showStackTraceError(e);
            return false;
        }
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }
}
