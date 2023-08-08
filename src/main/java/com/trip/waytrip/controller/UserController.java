package com.trip.waytrip.controller;

import com.trip.waytrip.dto.UserDto;
import com.trip.waytrip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto.Request request) {
        userService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Retrieve a single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto.Response> getUserById(@PathVariable(name = "userId") Long userId) {
        Optional<UserDto.Response> userResponse = userService.getUserById(userId);
        return userResponse.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Retrieve all users
    @GetMapping
    public ResponseEntity<List<UserDto.Response>> getAllUsers() {
        List<UserDto.Response> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update a user
    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable(name = "userId") Long userId, @RequestBody UserDto.Request requestDto) {
        userService.updateUser(userId, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Join a team
    @PostMapping("/{userId}/team/{teamId}")
    public ResponseEntity<Void> joinTeam(@PathVariable(name = "userId") Long userId, @PathVariable(name = "teamId") Long teamId) {
        userService.joinTeam(userId, teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
