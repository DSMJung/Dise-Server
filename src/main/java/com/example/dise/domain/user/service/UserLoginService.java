package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.request.UserLoginRequest;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.domain.repository.UserRepository;
import com.example.dise.domain.user.exception.PasswordMismatchException;
import com.example.dise.domain.user.exception.UserNotFoundException;
import com.example.dise.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String login(UserLoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.generateToken(user.getAccountId());
    }
}
