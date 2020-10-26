package com.ksv.springboottask.controller;

import com.ksv.springboottask.model.dto.AuthenticationRequestDto;
import com.ksv.springboottask.model.dto.AuthenticationResponseDto;
import com.ksv.springboottask.model.dto.UserRequestDto;
import com.ksv.springboottask.security.AuthenticationService;
import com.ksv.springboottask.util.JwtUtil;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getLogin(), requestDto.getPassword());
        return ResponseEntity.ok("The user has successfully registered.");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(
            @RequestBody AuthenticationRequestDto requestDto) {
        Authentication authentication;
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(
                    requestDto.getLogin(), requestDto.getPassword());
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Incorrect username or password", e);
        }
        var userDetails = (UserDetails) authentication.getPrincipal();
        var jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
