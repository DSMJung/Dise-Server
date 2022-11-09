package com.example.dise.domain.comment.domain;

import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public Comment(String content, User user, Feed feed) {
        this.content = content;
        this.user = user;
        this.feed = feed;
    }

    public void modifyComment(String content) {
        this.content = content;
    }

    public String getUserName() {
        return user.getName();
    }
    public Integer getUserId() {
        return user.getId();
    }

}
