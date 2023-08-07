package com.trip.waytrip.service;
import com.trip.waytrip.domain.Team;
import com.trip.waytrip.domain.User;
import com.trip.waytrip.dto.UserDto;
import com.trip.waytrip.repository.TeamRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    // Create
    @Transactional
    public void createUser(UserDto.Request requestDto) {
        User newUser = User.builder()
                .nickname(requestDto.getNickname())
                .email(requestDto.getEmail())
                .profileUrl(requestDto.getProfileUrl())
                .build();

        userRepository.save(newUser);
    }

    // Read (Single user)
    @Transactional(readOnly = true)
    public Optional<UserDto.Response> getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(UserDto.Response::new);
    }

    // Read (All users)
    @Transactional(readOnly = true)
    public List<UserDto.Response> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto.Response::new)
                .collect(Collectors.toList());
    }

    // Update
    @Transactional
    public void updateUser(Long id, UserDto.Request requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found."));
        user.updateProfile(requestDto);
        userRepository.save(user);
    }

    // Delete
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Join team
    @Transactional
    public void joinTeam(Long userId, Long teamId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found."));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalStateException("Team not found."));

        team.addUser(user);
        teamRepository.save(team); // This line may not be required depending on your JPA implementation.

    }
}