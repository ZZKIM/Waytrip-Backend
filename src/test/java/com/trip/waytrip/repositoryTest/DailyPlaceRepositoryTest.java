package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.domain.Address;
import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.domain.DailySchedule;
import com.trip.waytrip.domain.Place;
import com.trip.waytrip.dto.PlaceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyPlaceRepositoryTest extends ScheduleRepositoryTest {
    private Address address;
    private Place place;
    private DailySchedule dailySchedule;
    @BeforeEach
    void init() {
        address = Address.builder()
                .specificAddress("address1")
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
    }
    @Test
    @DisplayName("하루에 맞는 장소의 1개를 저장한다.")
    void save(){
        saveTeamAndFirstSchedule();
        //given
        placeRepository.save(place);

        //when
        DailyPlace dailyPlace = DailyPlace.builder()
                .place(place)
                .build();
        DailyPlace dailyPlace1 = dailyPlaceRepository.save(dailyPlace);

        //then
        assertThat(dailyPlace).isEqualTo(dailyPlace1);
    }
}
