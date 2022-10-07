package com.example.dise.domain.user.service;

import com.example.dise.domain.user.controller.dto.request.UpdatePasswordRequest;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {
    private final UserFacade userFacade;

    @Transactional
    public void updatePassword(UpdatePasswordRequest request) {
        User user = userFacade.getCurrentUser();
        userFacade.checkPassword(user, request.getPassword());
        user.updatePassword(request.getNewPassword());
    }
}
