package com.example.NoSqlMongoDb.service.impl;

import com.example.NoSqlMongoDb.domain.documents.User;
import com.example.NoSqlMongoDb.repository.UserRepository;
import com.example.NoSqlMongoDb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else throw new RuntimeException("User not founded!");
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> getByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> getByAgeGreaterThan(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> getByIsMarried(Boolean isMarried) {
        return userRepository.findByIsMarried(isMarried);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
