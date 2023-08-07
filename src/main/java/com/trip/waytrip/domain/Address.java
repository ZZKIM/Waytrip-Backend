package com.trip.waytrip.domain;

import com.trip.waytrip.dto.PlaceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn
    private Place place;
    @Column(nullable = false)
    private String specificAddress;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

    public Address(PlaceDto.Request addressDto) {
        this.specificAddress = addressDto.getSpecificAddress();
        this.latitude = addressDto.getLatitude();
        this.longitude = addressDto.getLongitude();
    }
    public void update(PlaceDto.Request addressDto) {
        this.specificAddress = addressDto.getSpecificAddress();
        this.latitude = addressDto.getLatitude();
        this.longitude = addressDto.getLongitude();
    }
}
