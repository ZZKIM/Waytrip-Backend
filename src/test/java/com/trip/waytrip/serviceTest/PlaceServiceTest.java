package com.trip.waytrip.serviceTest;

import com.trip.waytrip.dto.PlaceDto;

import com.trip.waytrip.service.PlaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class PlaceServiceTest {
    @Autowired
    private PlaceService placeService;

    PlaceDto.Request requestDto;

    @BeforeEach

    @Test
    void createPlaceTest() {
        PlaceDto.Request requestDto = new PlaceDto.Request();
        requestDto.setName("Test Place");
        requestDto.setSpecificAddress("Seoul, Gangnam-gu, Teheran-ro");
        requestDto.setLatitude(37.492566);
        requestDto.setLongitude(127.02946);
        requestDto.setOpenTime("11:00");
        requestDto.setCloseTime("14:00");
        requestDto.setDetail("This is a test place for unit test.");
        requestDto.setImageUrl("https://test-image.com");
        requestDto.setKeywords(Arrays.asList("test", "place"));

        placeService.createPlace(requestDto);

        List<PlaceDto.Response> responseList = placeService.getAllPlaces();
        assertNotNull(responseList);
        assertEquals(1, responseList.size());

        PlaceDto.Response response = responseList.get(0);
        assertEquals("Test Place", response.getName());
        assertEquals("Seoul, Gangnam-gu, Teheran-ro", response.getSpecificAddress());
        assertEquals(37.492566, response.getLatitude());
        assertEquals(127.02946, response.getLongitude());
        assertEquals("11:00", response.getOpenTime());
        assertEquals("14:00", response.getCloseTime());
        assertEquals("This is a test place for unit test.", response.getDetail());
        assertEquals("https://test-image.com", response.getImageUrl());
        assertEquals(Arrays.asList("test", "place"), response.getKeywords());
    }

    @Test
    void getPlaceByIdTest() {
        PlaceDto.Request requestDto = new PlaceDto.Request();
        requestDto.setName("Test Place");
        requestDto.setSpecificAddress("Seoul, Gangnam-gu, Teheran-ro");
        requestDto.setLatitude(37.492566);
        requestDto.setLongitude(127.02946);
        requestDto.setOpenTime("11:00");
        requestDto.setCloseTime("14:00");
        requestDto.setDetail("This is a test place for unit test.");
        requestDto.setImageUrl("https://test-image.com");
        requestDto.setKeywords(Arrays.asList("test", "place"));

        placeService.createPlace(requestDto);

        List<PlaceDto.Response> responseList = placeService.getAllPlaces();
        assertNotNull(responseList);
        assertEquals(1, responseList.size());

        Long id = responseList.get(0).getId();
        PlaceDto.Response response = placeService.getPlaceById(id);

        assertEquals("Test Place", response.getName());
        assertEquals("Seoul, Gangnam-gu, Teheran-ro", response.getSpecificAddress());
        assertEquals(37.492566, response.getLatitude());
        assertEquals(127.02946, response.getLongitude());
        assertEquals("11:00", response.getOpenTime());
        assertEquals("14:00", response.getCloseTime());
        assertEquals("This is a test place for unit test.", response.getDetail());
        assertEquals("https://test-image.com", response.getImageUrl());
        assertEquals(Arrays.asList("test", "place"), response.getKeywords());
    }

    @Test
    void updatePlaceTest() {
        PlaceDto.Request requestDto = new PlaceDto.Request();
        requestDto.setName("Test Place");
        requestDto.setSpecificAddress("Seoul, Gangnam-gu, Teheran-ro");
        requestDto.setLatitude(37.492566);
        requestDto.setLongitude(127.02946);
        requestDto.setOpenTime("11:00");
        requestDto.setCloseTime("14:00");
        requestDto.setDetail("This is a test place for unit test.");
        requestDto.setImageUrl("https://test-image.com");
        requestDto.setKeywords(Arrays.asList("test", "place"));

        placeService.createPlace(requestDto);

        List<PlaceDto.Response> responseList = placeService.getAllPlaces();
        assertNotNull(responseList);
        assertEquals(1, responseList.size());

        Long id = responseList.get(0).getId();

        PlaceDto.Request newRequestDto = new PlaceDto.Request();
        newRequestDto.setName("New Test Place");
        newRequestDto.setSpecificAddress("Seoul, Jongno-gu, Insa-dong");
        newRequestDto.setLatitude(37.574972);
        newRequestDto.setLongitude(126.986422);
        newRequestDto.setOpenTime("09:00");
        newRequestDto.setCloseTime("20:00");
        newRequestDto.setDetail("This is a new test place for unit test.");
        newRequestDto.setImageUrl("https://new-test-image.com");
        newRequestDto.setKeywords(Arrays.asList("new-test", "place"));

        placeService.updatePlace(id, newRequestDto);

        PlaceDto.Response response = placeService.getPlaceById(id);

        assertEquals("New Test Place", response.getName());
        assertEquals("Seoul, Jongno-gu, Insa-dong", response.getSpecificAddress());
        assertEquals(37.574972, response.getLatitude());
        assertEquals(126.986422, response.getLongitude());
        assertEquals("09:00", response.getOpenTime());
        assertEquals("20:00", response.getCloseTime());
        assertEquals("This is a new test place for unit test.", response.getDetail());
        assertEquals("https://new-test-image.com", response.getImageUrl());
        assertEquals(Arrays.asList("new-test", "place"), response.getKeywords());
    }

    @Test
    void deletePlaceTest() {
        PlaceDto.Request requestDto = new PlaceDto.Request();
        requestDto.setName("Test Place");
        requestDto.setSpecificAddress("Seoul, Gangnam-gu, Teheran-ro");
        requestDto.setLatitude(37.492566);
        requestDto.setLongitude(127.02946);
        requestDto.setOpenTime("11:00");
        requestDto.setCloseTime("14:00");
        requestDto.setDetail("This is a test place for unit test.");
        requestDto.setImageUrl("https://test-image.com");
        requestDto.setKeywords(Arrays.asList("test", "place"));

        placeService.createPlace(requestDto);

        List<PlaceDto.Response> responseList = placeService.getAllPlaces();
        assertNotNull(responseList);
        assertEquals(1, responseList.size());

        Long id = responseList.get(0).getId();

        placeService.deletePlace(id);

        responseList = placeService.getAllPlaces();
        assertNotNull(responseList);
        assertEquals(0, responseList.size());
    }

}