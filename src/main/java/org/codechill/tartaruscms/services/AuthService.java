package org.codechill.tartaruscms.services;

import lombok.RequiredArgsConstructor;
import org.codechill.tartaruscms.repository.UserRepository;
import org.codechill.tartaruscms.services.auth.JwtService;
import org.codechill.tartaruscms.services.auth.config.AuthConfig;
import org.codechill.tartaruscms.dto.user.LoginRequest;
import org.codechill.tartaruscms.dto.user.RegisterRequest;
import org.codechill.tartaruscms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        UserDetails user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User " + loginRequest.getUsername() + " is not registered"));

        return jwtService.getToken(user);
    }

    public String register(RegisterRequest registerRequest) {
        User user = new User(
                registerRequest.getName(),
                registerRequest.getUsername(),
                passwordEncoder.encode(registerRequest.getPassword())
        );

        userRepository.save(user);

        return jwtService.getToken(user);
    }
}
