package com.example.sakiladb.Dtos;

import com.example.sakiladb.entities.Actor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class ActorPartial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Short id;
    @Column(name = "first_name")
    private String firstName;
/*
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName; */

    public  static ActorPartial toDto (Actor actor)
    {
        ActorPartial dto = new ActorPartial();
        dto.setId(actor.getId());
        dto.setFirstName(actor.getFirstName());
     //   dto.setFullName(actor.getFullName());

        return dto;

    }
}
