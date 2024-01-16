package com.imcjava.controllers;

import com.imcjava.dto.LoginRequest;
import com.imcjava.dto.LoginResponse;
import com.imcjava.dto.userDto.SignupRequest;
import com.imcjava.services.user.MyUserService;
import com.imcjava.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final MyUserService myUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginController(MyUserService myUserService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.myUserService = myUserService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        return myUserService.signup(signupRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails userDetails;
        try {
            userDetails = myUserService.loadUserByUsername(loginRequest.getEmail());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok().body(new LoginResponse(token));

    }


}
