package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.domain.*;
import com.trip.waytrip.repository.DayScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayScheduleTest extends RepositoryTest{
    private User user;
    private Schedule schedule;
    private Address address;
    private Address address0;
    private Address address1;
    private Address address2;
    private Address address3;
    private Address address4;
    private Place place;
    private Place place0;
    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;
    private DayPlace dayPlace1;
    private DayPlace dayPlace2;
    private DayPlace dayPlace3;
    private DayPlace dayPlace4;
    private DayPlace dayPlace5;
    @BeforeEach
    void init() {
        user = User.builder()
                .email("email")
                .nickname("가희")
                .profileUrl("이미지")
                .build();
        schedule = Schedule.builder()
                .name("제주도")
                .imageUrl("image")
                .startDate(LocalDate.of(2023,01,01))
                .endDate(LocalDate.of(2023,01,02))
                .team(
                        teamRepository.save(
                                new Team()
                        )
                )
                .build();
        address = Address.builder()
                .specificAddress("address")
                .latitude(35.8905477)
                .longitude(128.6121117)
                .build();
        place = Place.builder()
                .name("경북대학교")
                .openTime("1")
                .closeTime("2")
                .address(address)
                .imageUrl("image")
                .detail("detail")
                .build();
        address0 = Address.builder()
                .specificAddress("address1")
                .latitude(35.8905477)
                .longitude(128.6121117)
                .build();
        place0 = Place.builder()
                .name("경북대학교")
                .openTime("1")
                .closeTime("2")
                .address(address0)
                .imageUrl("image")
                .detail("detail")
                .build();

        address1 = Address.builder()
                .specificAddress("address2")
                .latitude(37.5665)
                .longitude(126.9780)
                .build();
        place1 = Place.builder()
                .name("광화문")
                .openTime("10")
                .closeTime("21")
                .address(address1)
                .imageUrl("image2")
                .detail("detail2")
                .build();

        address2 = Address.builder()
                .specificAddress("address3")
                .latitude(37.5667)
                .longitude(126.9784)
                .build();
        place2 = Place.builder()
                .name("창덕궁")
                .openTime("9")
                .closeTime("17")
                .address(address2)
                .imageUrl("image3")
                .detail("detail3")
                .build();

        address3 = Address.builder()
                .specificAddress("address4")
                .latitude(37.5790884)
                .longitude(126.9960476)
                .build();
        place3 = Place.builder()
                .name("북촌한옥마을")
                .openTime("9")
                .closeTime("18")
                .address(address3)
                .imageUrl("image4")
                .detail("detail4")
                .build();

        address4 = Address.builder()
                .specificAddress("address5")
                .latitude(35.1595453)
                .longitude(129.0475728)
                .build();
        place4 = Place.builder()
                .name("부산 해운대해수욕장")
                .openTime("24")
                .closeTime("24")
                .address(address4)
                .imageUrl("image5")
                .detail("detail5")
                .build();
    }
    @Test
    public void save(){

        List<DayPlace> dayPlaces = new ArrayList<>();

        placeRepository.save(place);
        DayPlace dayPlace = DayPlace.builder()
                .place(place)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace));

        placeRepository.save(place0);
        DayPlace dayPlace0 = DayPlace.builder()
                .place(place0)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace0));

        placeRepository.save(place1);
        DayPlace dayPlace1 = DayPlace.builder()
                .place(place1)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace1));

        placeRepository.save(place2);
        DayPlace dayPlace2 = DayPlace.builder()
                .place(place2)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace2));

        placeRepository.save(place3);
        DayPlace dayPlace3 = DayPlace.builder()
                .place(place3)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace3));

        placeRepository.save(place4);
        DayPlace dayPlace4 = DayPlace.builder()
                .place(place4)
                .build();
        dayPlaces.add(dayPlaceRepository.save(dayPlace4));

        assertThat(dayPlaces.size()).isEqualTo(6);
        scheduleRepository.save(schedule);

        DaySchedule daySchedule = DaySchedule.builder()
                .date(LocalDate.of(2023,03,02))
                .dayPlaces(dayPlaces)
                .schedule(schedule)
                .build();
        DaySchedule daySchedule1 = dayScheduleRepository.save(daySchedule);

        assertThat(daySchedule).isEqualTo(daySchedule1);

    }
}
