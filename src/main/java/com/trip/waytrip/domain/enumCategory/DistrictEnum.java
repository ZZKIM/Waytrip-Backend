package com.trip.waytrip.domain.enumCategory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DistrictEnum {
    ONE_GU("구역1"),
    TWO_GU("구역2"),
    THREE_GU("구역3"),
    FOUR_GU("구역4"),
    FIVE_GU("구역5"),
    SIX_GU("구역6"),
    SEVEN_GU("구역7"),
    EIGHT_GUN("구역8"),
    NINE_GUN("구역9");

    @Getter
    private final String description;
}
