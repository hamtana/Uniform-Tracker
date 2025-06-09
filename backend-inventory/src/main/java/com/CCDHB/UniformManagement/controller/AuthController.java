package com.CCDHB.UniformManagement.controller;

import com.CCDHB.UniformManagement.DTO.LoginRequest;
import com.CCDHB.UniformManagement.DTO.RegisterRequest;
import com.CCDHB.UniformManagement.security.RegisterUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class AuthController {

    private final RegisterUserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(RegisterUserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            Authentication auth = authenticationManager.authenticate(authToken);

            SecurityContextHolder.getContext().setAuthentication(auth);

            // ✅ Explicitly create and bind session
            httpRequest.getSession(true)
                    .setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
