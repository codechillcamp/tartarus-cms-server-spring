package org.codechill.tartaruscms.controllers.v1;

import org.codechill.tartaruscms.dto.user.LoginRequest;
import org.codechill.tartaruscms.dto.user.RegisterRequest;
import org.codechill.tartaruscms.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody() LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public String register(@RequestBody() RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}
