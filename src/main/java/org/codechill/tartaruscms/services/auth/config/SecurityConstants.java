package org.codechill.tartaruscms.services.auth.config;

public class SecurityConstants {

    public static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    public static final long EXPIRATION_TIME = 1000 * 60 * 24; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/users/login";
}