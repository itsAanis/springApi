package com.example.sakiladb.entities;
import com.example.sakiladb.Dtos.ActorPartial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;
    private String title;
    private String description;
    @Column(name = "release_year")
    private int releaseYear;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<ActorPartial> cast = new ArrayList<>();
}
