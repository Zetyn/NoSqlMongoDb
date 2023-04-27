package com.example.NoSqlMongoDb.repository;

import com.example.NoSqlMongoDb.domain.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Long>  {
    User findByEmail(String email);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByIsMarried(Boolean isMarried);
}
