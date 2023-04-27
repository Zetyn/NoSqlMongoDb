package com.example.NoSqlMongoDb.web;

import com.example.NoSqlMongoDb.domain.documents.User;
import com.example.NoSqlMongoDb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/user/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.FOUND);
    }

    @GetMapping("/user/getByEmail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.FOUND);
    }

    @GetMapping("/user/getByFirstName/{firstName}")
    public ResponseEntity<?> getByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(userService.getByFirstName(firstName), HttpStatus.FOUND);
    }

    @GetMapping("/user/getByLastName/{lastName}")
    public ResponseEntity<?> getByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(userService.getByLastName(lastName), HttpStatus.FOUND);
    }

    @GetMapping("/user/getByAgeGreaterThan/{age}")
    public ResponseEntity<?> getByAgeGreaterThan(@PathVariable int age) {
        return new ResponseEntity<>(userService.getByAgeGreaterThan(age), HttpStatus.FOUND);
    }

    @GetMapping("/user/getByIsMarried/{isMarried}")
    public ResponseEntity<?> getByIsMarried(@PathVariable Boolean isMarried) {
        return new ResponseEntity<>(userService.getByIsMarried(isMarried), HttpStatus.FOUND);
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.FOUND);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
