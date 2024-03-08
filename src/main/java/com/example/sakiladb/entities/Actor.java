package com.example.sakiladb.entities;
import com.example.sakiladb.Dtos.FilmPartial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Short id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
/*
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName; */

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )

    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<FilmPartial> films = new ArrayList<>();


}
