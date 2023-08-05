package com.trip.waytrip.domain;

import com.trip.waytrip.domain.enumCategory.DistrictEnum;
import com.trip.waytrip.domain.enumCategory.ThemeEnum;
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
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ThemeEnum theme;

    @Enumerated(EnumType.STRING)
    private DistrictEnum district;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
}
