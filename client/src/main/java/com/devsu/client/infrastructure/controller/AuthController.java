package com.devsu.client.infrastructure.controller;

import com.devsu.client.application.dto.AuthRequestDTO;
import com.devsu.client.application.dto.AuthResponseDTO;
import com.devsu.client.infrastructure.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequest) {
        var login = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(login);

        String jwt = jwtUtil.create(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponseDTO(jwt));
    }
}
