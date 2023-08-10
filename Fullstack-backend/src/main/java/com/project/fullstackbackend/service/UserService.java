package com.project.fullstackbackend.service;

import com.project.fullstackbackend.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();
    User getUserById(Long id);

    User updateUser(User user,long id);

    String deleteUser(long id);

}
