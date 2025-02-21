package org.data.services;

import org.data.entities.User;

public interface UserService {

    boolean hasPermission(String username, String permission);  // Fixed return type

    User getUserByUsername(String username);
}
