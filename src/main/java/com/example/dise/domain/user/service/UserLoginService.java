package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.request.UserLoginRequest;
import com.example.dise.domain.user.controller.dto.response.TokenResponse;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.domain.repository.UserRepository;
import com.example.dise.domain.user.exception.UserNotFoundException;
import com.example.dise.domain.user.facade.UserFacade;
import com.example.dise.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse login(UserLoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        userFacade.checkPassword(user, request.getPassword());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(request.getAccountId()))
                .build();
    }
}
