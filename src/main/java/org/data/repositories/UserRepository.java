package org.data.repositories;

import org.data.entities.User;

import java.util.Optional;

public interface UserRepository{

    Optional<User> findByUsername(String username);
    void saveUser(User user);
}
