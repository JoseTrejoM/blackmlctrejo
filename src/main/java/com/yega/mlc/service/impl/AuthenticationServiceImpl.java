package com.yega.mlc.service.impl;

import com.yega.mlc.common.Decrypt;
import com.yega.mlc.common.Encrypt;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.LoginAppDTO;
import com.yega.mlc.dto.LoginRequestDTO;
import com.yega.mlc.dto.LoginResponseDTO;
import com.yega.mlc.dto.UserDetailsDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.security.JwtService;
import com.yega.mlc.service.AuthenticationService;
import com.yega.mlc.service.ConfiguracionSysService;
import com.yega.mlc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("authenticationServiceCore")
public class AuthenticationServiceImpl extends AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("configuracionSysServiceCore")
    private ConfiguracionSysService configuracionSysService;

    @Override
    public LoginResponseDTO validateUser(LoginRequestDTO userLogin) throws ServiceException {
        try {
            var auth = validateAuth(userLogin);
            jwtService.deleteToken((UserDetailsDTO) auth.getPrincipal());
            String token = jwtService.createToken((UserDetailsDTO) auth.getPrincipal());

            var loginResponse = new LoginResponseDTO();
            loginResponse.setIdToken(token);
            return loginResponse;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public LoginResponseDTO validateByApp(LoginAppDTO appLogin) throws ServiceException {
        try {
            if (isValidAppKey(appLogin.getAppKey())) {
                return validateUser(getUsuarioApp());
            } else {
                var errorCode = new ErrorCodeDTO(HttpStatus.UNAUTHORIZED, String.format("AppKey invalid", appLogin.getAppKey()));
                throw new ServiceException(errorCode, errorCode.getMessage());
            }
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    protected LoginRequestDTO getUsuarioApp() {
        try {
            var param = configuracionSysService.parameterByName(SystemConstants.PASSWORD_USUARIO_SISTEMA);
            var user = userService.getById(SystemConstants.USUARIO_SISTEMA);
            var passwordEnc = Encrypt.encrypt(param.getValor());
            return new LoginRequestDTO(user.getUsuario(), passwordEnc);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    protected boolean isValidAppKey(String appKey) {
        try {
            var appKeyWeb = configuracionSysService.parameterByName(SystemConstants.APP_KEY_WEB);
            var appKeyMovil = configuracionSysService.parameterByName(SystemConstants.APP_KEY_MOVIL);

            var appKeyDec = Decrypt.decrypt(appKey);
            return appKeyDec != null && (appKeyDec.equals(appKeyWeb.getValor()) || appKeyDec.equals(appKeyMovil.getValor()));
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    private Authentication validateAuth(LoginRequestDTO userLogin) throws ServiceException {
        try {
            var passwordDec = Decrypt.decrypt(userLogin.getPassword());
            if(passwordDec == null ){
                var errorCode = new ErrorCodeDTO(HttpStatus.UNAUTHORIZED, String.format("Bad credentials"));
                throw new ServiceException(errorCode, errorCode.getMessage());
            }
            userLogin.setPassword(userLogin.getUsername() + passwordDec);
            var userAuthToken = new UsernamePasswordAuthenticationToken(userLogin.getUsername(),
                    userLogin.getPassword());
            return authenticationManager.authenticate(userAuthToken);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }    

}
