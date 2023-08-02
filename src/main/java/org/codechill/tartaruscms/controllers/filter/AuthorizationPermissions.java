package org.codechill.tartaruscms.controllers.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.codechill.tartaruscms.repository.UserRepository;
import org.codechill.tartaruscms.services.auth.JwtService;
import org.codechill.tartaruscms.services.auth.config.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

@Service
public class AuthorizationPermissions {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private HttpServletRequest request;


    public boolean checkPermissions(String permission) {

        String authorization = getTokenFromRequest(request);
        authorization.substring(7);
        String username = jwtService.getUsernameFromToken(authorization);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        GrantedAuthority[] authorities = userDetails.getAuthorities()
                .toArray(new GrantedAuthority[userDetails.getAuthorities().size()]);

        for (GrantedAuthority authority :
                authorities) {
            if (authority.getAuthority().equals(permission)) {
                return true;
            }
        }

        return false;
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            return authHeader.substring(7);
        }
        return null;
    }
}
