package com.example.dise.domain.user.domain.repository;

import com.example.dise.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);
}
