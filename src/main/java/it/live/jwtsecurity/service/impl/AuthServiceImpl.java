package it.live.jwtsecurity.service.impl;

import it.live.jwtsecurity.config.JwtService;
import it.live.jwtsecurity.entity.User;
import it.live.jwtsecurity.entity.enums.Role;
import it.live.jwtsecurity.payload.ApiResponse;
import it.live.jwtsecurity.payload.LoginDTO;
import it.live.jwtsecurity.payload.RegisterDTO;
import it.live.jwtsecurity.repository.UserRepository;
import it.live.jwtsecurity.service.AuthService;
import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<ApiResponse> register(RegisterDTO registerDTO) {
        var user = User.builder()
                .firstName(registerDTO.getFirstName())
                .lastName(registerDTO.getLastName())
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return ResponseEntity.ok(ApiResponse.builder().token(jwtToken).build());
    }

    @Override
    public ResponseEntity<ApiResponse> login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail() , loginDTO.getPassword()));
        var user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow();
        return ResponseEntity.ok(ApiResponse.builder().token(jwtService.generateToken(user)).build());
    }
}
