package com.trip.waytrip.service;

import com.trip.waytrip.domain.Address;
import com.trip.waytrip.domain.Place;
import com.trip.waytrip.dto.PlaceDto;
import com.trip.waytrip.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    @Transactional
    public void createPlace(PlaceDto.Request requestDto) {
        Address address = new Address(requestDto);
        Place place = new Place(requestDto, address);

        placeRepository.save(place);
    }

    public List<PlaceDto.Response> getAllPlaces() {
        return placeRepository.findAll().stream()
                .map(PlaceDto.Response::new)
                .collect(Collectors.toList());
    }

    public PlaceDto.Response getPlaceById(Long id) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Place not found with id: " + id));
        return new PlaceDto.Response(place);
    }

    @Transactional
    public void updatePlace(Long id, PlaceDto.Request requestDto) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Place not found with id: " + id));
        place.getAddress().update(requestDto);
        place.update(requestDto);

        placeRepository.save(place);
    }

    @Transactional
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}
