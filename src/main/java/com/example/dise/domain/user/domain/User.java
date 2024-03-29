package com.example.dise.domain.user.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 4, nullable = false)
    private String name;

    @Builder
    public User(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

    public void updateUserInfo (String name) {
        this.name = name;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
