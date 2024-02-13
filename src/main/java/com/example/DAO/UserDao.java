package com.example.DAO;


import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void saveUser(User user);

    void update(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);
}
