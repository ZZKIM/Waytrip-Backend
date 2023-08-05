package com.trip.waytrip.domain;

import com.trip.waytrip.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Memo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    private String title;

    @Setter
    @Column(nullable = false, length = 1000)
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private User user;

    @JoinColumn(name = "daily_place_id")
    @ManyToOne(optional = false)
    private DailyPlace dailyPlace;
}
