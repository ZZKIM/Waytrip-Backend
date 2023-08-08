package com.trip.waytrip.service;

import com.trip.waytrip.domain.Comment;
import com.trip.waytrip.domain.User;
import com.trip.waytrip.dto.DayPlaceDto;
import com.trip.waytrip.repository.CommentRepository;
import com.trip.waytrip.repository.DayPlaceRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DayPlaceService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final DayPlaceRepository dayPlaceRepository;
    public void createComment(DayPlaceDto.CommentRequestDto commentRequestDto){
        commentRepository.save(Comment.builder()
                .user(
                        userRepository.findById(
                                commentRequestDto.getUserId()
                        ).orElseThrow()
                )
                .content(commentRequestDto.getContent())
                .build());
    }
    public DayPlaceDto.Response getAllContentByPlace(Long dayPlaceId){
        DayPlace dayPlace =

        return dayPlaceRepository.findById(dayPlaceId).get().getComments().stream().map(DayPlaceDto.CommentResponseDto::new).collect(Collectors.toList());
    }

}
