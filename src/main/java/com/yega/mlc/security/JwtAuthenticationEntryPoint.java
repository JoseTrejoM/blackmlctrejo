package com.yega.mlc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yega.mlc.dto.ErrorCodeDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint  {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
                var errorCode = new ErrorCodeDTO(HttpStatus.FORBIDDEN, authException.getMessage());
                var mapeador = new ObjectMapper();                
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setStatus(errorCode.getHttpStatus().value());
                response.getWriter().write(mapeador.writeValueAsString(errorCode));
                response.getWriter().flush();
        
    }
    
}
