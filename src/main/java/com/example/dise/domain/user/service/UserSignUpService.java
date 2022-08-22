package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.domain.repository.Repository;
import com.example.dise.domain.user.exception.AlreadyUserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final Repository repository;

    @Transactional
    public void signUp(UserSignUpRequest request) {
        if (repository.findByAccountId(request.getAccountId()).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();

        repository.save(user);
    }
}
