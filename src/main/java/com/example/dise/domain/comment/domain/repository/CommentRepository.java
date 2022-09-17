package com.example.dise.domain.comment.domain.repository;

import com.example.dise.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByFeedId(Integer feedId);

}
