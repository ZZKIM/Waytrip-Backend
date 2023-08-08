package com.trip.waytrip.controller;

import com.trip.waytrip.dto.PlaceDto;
import com.trip.waytrip.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @PostMapping("/place")
    public ResponseEntity<Void> createPlace(@RequestBody PlaceDto.Request requestDto) {
        placeService.createPlace(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<Void> createAllPlace(@RequestBody List<PlaceDto.Request> requestDtos) {
        placeService.createAllPlace(requestDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlaceDto.Response>> getAllPlaces() {
        List<PlaceDto.Response> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<PlaceDto.Response> getPlaceById(@PathVariable(name = "placeId") Long placeId) {
        PlaceDto.Response placeDto = placeService.getPlaceById(placeId);
        return new ResponseEntity<>(placeDto, HttpStatus.OK);
    }

    @PutMapping("/{placeId}")
    public ResponseEntity<Void> updatePlace(@PathVariable(name = "placeId") Long placeId, @RequestBody PlaceDto.Request requestDto) {
        placeService.updatePlace(placeId, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity<Void> deletePlace(@PathVariable(name = "placeId") Long placeId) {
        placeService.deletePlace(placeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
