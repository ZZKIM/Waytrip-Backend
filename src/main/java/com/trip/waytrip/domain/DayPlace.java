package com.trip.waytrip.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DayPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dayPlace", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
    @Setter
    @ManyToOne
    private Place place;

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
