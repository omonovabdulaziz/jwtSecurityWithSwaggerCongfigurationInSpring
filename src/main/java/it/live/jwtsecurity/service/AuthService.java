package it.live.jwtsecurity.service;

import it.live.jwtsecurity.payload.ApiResponse;
import it.live.jwtsecurity.payload.LoginDTO;
import it.live.jwtsecurity.payload.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<ApiResponse> register(RegisterDTO registerDTO);

    ResponseEntity<ApiResponse> login(LoginDTO loginDTO);
}
