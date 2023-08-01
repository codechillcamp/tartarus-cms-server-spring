package org.codechill.tartaruscms.controllers.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codechill.tartaruscms.entities.StorePermission;
import org.codechill.tartaruscms.entities.User;
import org.codechill.tartaruscms.repository.UserRepository;
import org.codechill.tartaruscms.services.auth.JwtService;
import org.codechill.tartaruscms.services.auth.config.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

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

        GrantedAuthority[] authorities = userDetails.getAuthorities().toArray(new GrantedAuthority[userDetails.getAuthorities().size()]);

        GrantedAuthority grantedAuthority = null;
        for (GrantedAuthority authority :
                authorities) {
            System.out.println(authority.getAuthority());
            System.out.println(permission);
            System.out.println(authority.getAuthority().equals(permission));
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
