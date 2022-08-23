package com.example.dise.domain.user.service;


import com.example.dise.domain.user.controller.dto.request.UpdateUserInfoRequest;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    @Transactional
    public void excute(UpdateUserInfoRequest request) {

        User user = userFacade.getCurrentUser();

        user.updateUserInfo (
                passwordEncoder.encode(request.getPassword()),
                request.getName());
    }
}
