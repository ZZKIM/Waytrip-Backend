package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.domain.Address;
import com.trip.waytrip.domain.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
public class PlaceRepositoryTest extends RepositoryTest {

    private Address address;
    private Address address0;
    private Address address1;
    private Address address2;
    private Address address3;
    private Address address4;
    private Address address5;
    private Place place;
    private Place place0;
    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;


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
        address0 = Address.builder()
                .specificAddress("address1")
                .latitude(35.8905477)
                .longitude(128.6121117)
                .build();
        place0 = Place.builder()
                .name("경북대학교")
                .openTime("1")
                .closeTime("2")
                .address(address)
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
    @DisplayName("장소를 저장한다.")
    void save() {
        //given, when
        Place savedPlace = placeRepository.save(place);

        //then
        assertThat(savedPlace.getId()).isNotNull();
        assertThat(savedPlace).isEqualTo(place);
    }
    @Test
    @DisplayName("id로 장소를 찾아올 수 있다.")
    void findById() {
        //given
        Place savedPlace = placeRepository.save(place);

        //when
        Place findPlace = placeRepository.findById(savedPlace.getId())
                .orElseThrow(NoSuchElementException::new);

        //then
        assertThat(findPlace).isEqualTo(savedPlace);
    }
    @Test
    @DisplayName("장소의 주소 정보를 찾을 수 있다.")
    void findAddress() {
        //given
        Place savedPlace = placeRepository.save(place);

        //when
        Address savedAddress = savedPlace.getAddress();

        //then
        assertThat(savedAddress).isEqualTo(address);
    }

    @Test
    @DisplayName("모든 장소를 조회한다.")
    void findAllPlace() {
        //given
        placeRepository.save(place0);
        placeRepository.save(place1);
        placeRepository.save(place2);
        placeRepository.save(place3);
        placeRepository.save(place4);

        //when
        List<Place> places = placeRepository.findAll();

        //then
        assertThat(places.size()).isEqualTo(5);
        assertThat(places).contains(place0, place1, place2, place3, place4);
    }
}
