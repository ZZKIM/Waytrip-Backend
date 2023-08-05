package com.trip.waytrip.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Team team;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private final Set<String> imageURLs = new LinkedHashSet<>();
}
