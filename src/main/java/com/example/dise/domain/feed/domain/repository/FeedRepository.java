package com.example.dise.domain.feed.domain.repository;

import com.example.dise.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
