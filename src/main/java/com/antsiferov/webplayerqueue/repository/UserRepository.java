package com.antsiferov.webplayerqueue.repository;

import com.antsiferov.webplayerqueue.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);

    User findUserByName(String name);

}