package com.example.dise.domain.feed.domain;

import com.example.dise.domain.feed.domain.type.Category;
import com.example.dise.domain.user.domain.User;
import com.example.dise.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, Category category, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }

    public void modifyFeed(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

}
