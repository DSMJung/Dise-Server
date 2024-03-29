package com.example.dise.domain.feed.domain.repository;

import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.type.Category;
import com.example.dise.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Integer> {

    List<Feed> findByCategoryOrderByCreatedAtDesc(Category category);

    List<Feed> findByTitleContainingOrderByCreatedAtDesc(String keyword);

    List<Feed> findAllByOrderByIdDesc();

    List<Feed> findAllByUserOrderByCreatedAtDesc(User user);

}
