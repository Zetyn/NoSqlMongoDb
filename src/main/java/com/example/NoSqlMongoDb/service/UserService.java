package com.example.NoSqlMongoDb.service;

import com.example.NoSqlMongoDb.domain.documents.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User getByEmail(String email);
    List<User> getByFirstName(String firstName);
    List<User> getByLastName(String lastName);
    List<User> getByAgeGreaterThan(int age);
    List<User> getByIsMarried(Boolean isMarried);
    User create(User user);
    void deleteById(Long id);
}
