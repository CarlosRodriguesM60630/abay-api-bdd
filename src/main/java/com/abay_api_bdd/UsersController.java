package com.abay_api_bdd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final List<Users> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        users.add(user);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        return users.stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    public List<Users> getAllUsers() {
        return users;
    }
}
