package it.live.jwtsecurity.controller;

import it.live.jwtsecurity.payload.ApiResponse;
import it.live.jwtsecurity.payload.LoginDTO;
import it.live.jwtsecurity.payload.RegisterDTO;
import it.live.jwtsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDTO loginDTO) {
return authService.login(loginDTO);
    }

}
