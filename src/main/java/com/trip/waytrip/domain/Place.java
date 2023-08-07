package com.trip.waytrip.domain;

import com.trip.waytrip.domain.enumCategory.DistrictEnum;
import com.trip.waytrip.domain.enumCategory.ThemeEnum;
import com.trip.waytrip.dto.PlaceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ThemeEnum theme;

    @Enumerated(EnumType.STRING)
    private DistrictEnum district;

    @OneToOne
    private Address address;

    @Column
    private String openTime;

    @Column
    private String closeTime;

    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private String imageUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "keywords")
    private List<String> keywords = new ArrayList<>();

    public Place(PlaceDto.Request requestDto, Address address) {
        this.name = requestDto.getName();
        this.theme = requestDto.getTheme();
        this.district = requestDto.getDistrict();
        this.address = address;
        this.openTime = requestDto.getOpenTime();
        this.closeTime = requestDto.getCloseTime();
        this.detail = requestDto.getDetail();
        this.imageUrl = requestDto.getImageUrl();
        this.keywords = requestDto.getKeywords();
    }

    public void update(PlaceDto.Request requestDto) {
        this.name = requestDto.getName();
        this.theme = requestDto.getTheme();
        this.district = requestDto.getDistrict();
        this.openTime = requestDto.getOpenTime();
        this.closeTime = requestDto.getCloseTime();
        this.detail = requestDto.getDetail();
        this.imageUrl = requestDto.getImageUrl();
        this.keywords = requestDto.getKeywords();
    }
}
