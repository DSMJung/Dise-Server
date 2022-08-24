package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.response.UserInfoResponse;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetUserInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserInfoResponse execute() {

        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .build();
    }
}
