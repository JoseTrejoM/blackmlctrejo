package com.yega.mlc.constants;

public final class JwtConstants {

    private JwtConstants() {
    }

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORITIES = "authorities";
    public static final String URL_LOGIN_V1 = "/api/v1/auth/login";
    public static final String URL_LOGIN_APP_V1 = "/api/v1/auth/loginapp";
    public static final String SWAGGER_PATH = "/swagger-ui/*";
    public static final String SWAGGER_UI = "/swagger-ui.html";
    public static final String SWAGGER_API_DOCS_PATH = "/v3/api-docs";
    public static final String SWAGGER_API_DOCS_PATH_ALL = "/v3/api-docs/*";

    public static final String AUTHORIZE_REQUESTS [] = new String[] {URL_LOGIN_V1, SWAGGER_PATH, SWAGGER_UI, SWAGGER_API_DOCS_PATH,
            SWAGGER_API_DOCS_PATH_ALL, URL_LOGIN_APP_V1};
}
