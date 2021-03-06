package com.blog.controller;

import com.blog.api.request.LoginRequest;
import com.blog.api.request.RegisterRequest;
import com.blog.api.response.*;
import com.blog.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final CheckService checkService;

    @Autowired
    public ApiAuthController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/check")
    public ResponseEntity<CheckResponse> check() {
        return ResponseEntity.ok(checkService.check());
    }

    @GetMapping("/captcha")
    public ResponseEntity<CaptchaResponse> captcha() throws IOException {
        return ResponseEntity.ok(checkService.captcha());
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(checkService.register(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(checkService.login(request));
    }

    @GetMapping("/auth/logout")
    public ResponseEntity<LogoutResponse> logout() {
        return ResponseEntity.ok(checkService.logout());
    }
}

