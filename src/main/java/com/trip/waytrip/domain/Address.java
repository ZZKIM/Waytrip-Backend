package com.trip.waytrip.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(nullable = false)
    private String specificAddress;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

}
