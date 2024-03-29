package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.response.UserInfoResponse;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.domain.repository.UserRepository;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WithdrawalService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute() {

        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
    }
}
