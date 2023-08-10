package com.project.fullstackbackend.service.impl;

import com.project.fullstackbackend.exception.UserNotFoundException;
import com.project.fullstackbackend.model.User;
import com.project.fullstackbackend.repository.UserRepository;
import com.project.fullstackbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private  UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser=repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        existingUser.setUserName(user.getUserName());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        repository.save(existingUser);
        return existingUser;
    }

    @Override
    public String deleteUser(long id) {
        repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        repository.deleteById(id);
        return "User ID: " + id + "Deleted Successfully";

    }
}
