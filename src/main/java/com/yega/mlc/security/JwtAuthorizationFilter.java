package com.yega.mlc.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yega.mlc.constants.JwtConstants;
import com.yega.mlc.dto.ErrorCodeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private ApiUserDetailService apiUserDetailService;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader(JwtConstants.HEADER_AUTHORIZATION);
        var listException = Arrays.asList(JwtConstants.AUTHORIZE_REQUESTS);
        
        if (!listException.contains(request.getRequestURI())
                && StringUtils.startsWithIgnoreCase(authorizationHeader, JwtConstants.HEADER_TOKEN_PREFIX)) {
            String token = authorizationHeader.replace(JwtConstants.HEADER_TOKEN_PREFIX, "");
            String tokenRefresh = null;
            if (jwtService.isValidPattern(token)) {
                try {
                    String username = jwtService.extractUsername(token);

                    var userDetails = apiUserDetailService.loadUserByUsername(username);
                    String tokenInCache = jwtService.createToken(userDetails);
                    if (jwtService.validateToken(token, userDetails, tokenInCache)) {
                        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        tokenRefresh = refreshToken(token, userDetails);
                    } else {
                        jwtService.deleteToken(userDetails);
                        log.error("Bad credentials {}", username);
                        createServiceException(response, HttpStatus.UNAUTHORIZED, "Bad credentials");
                        return;
                    }
                } catch (Exception e) {
                    log.error("Internal error {}", e);
                    createServiceException(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
                    return;
                }
            } else {
                log.error("Is not JWT valid {}", token);
                createServiceException(response, HttpStatus.BAD_REQUEST, "Is not JWT valid");
                return;
            }

            if (StringUtils.hasText(tokenRefresh)) {
                response.setHeader(JwtConstants.HEADER_AUTHORIZATION, JwtConstants.HEADER_TOKEN_PREFIX.concat(tokenRefresh));
            }
        }

        filterChain.doFilter(request, response);

    }

    private void createServiceException(HttpServletResponse response, HttpStatus httpStatus, String message)
            throws JsonProcessingException, IOException {
        var errorCode = new ErrorCodeDTO(httpStatus, message);
        var mapeador = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(httpStatus.value());
        response.getWriter().write(mapeador.writeValueAsString(errorCode));
        response.getWriter().flush();
    }

    private String refreshToken(String token, UserDetails userDetails) {        
        var dateToken = jwtService.extractExpiresAt(token);

        var calMin = Calendar.getInstance();
        calMin.add(Calendar.MINUTE, -2);

        var calToken = Calendar.getInstance();
        calToken.setTime(dateToken);
        calToken.add(Calendar.MINUTE, -1);

        var calMax = Calendar.getInstance();
        boolean willTokenDead = calToken.after(calMin) && calToken.before(calMax);
        String refreshToken = token;
        if (willTokenDead) {
            jwtService.deleteToken(userDetails);
            refreshToken = jwtService.createToken(userDetails);
        }
        return refreshToken;
    }

}
