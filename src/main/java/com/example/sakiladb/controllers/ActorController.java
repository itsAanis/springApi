package com.example.sakiladb.controllers;


import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.controllers.input.ActorInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.sakiladb.repositories.ActorRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ActorController {
    ActorRepository actorRepository;
    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors/{id}")
    public Actor getActorById(@PathVariable("id")short id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "no actor"));
    }

    @PostMapping("/actor")
    public ResponseEntity<Actor> addActor(@RequestBody ActorInput input)
    {
        Actor actor = new Actor();
        actor.setFirstName(input.getFirstName());
        actor.setLastName(input.getLastName());

        Actor savedActor = actorRepository.save(actor);
        return ResponseEntity.ok(savedActor);
    }

    @PutMapping("/actor/update/{id}")
    public ResponseEntity<Actor> update(@PathVariable(value = "id")Short id, @RequestBody ActorInput input)
    {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        actor.setFirstName(input.getFirstName());
        actor.setLastName(input.getLastName());
        Actor updatedActor = actorRepository.save(actor);
        return ResponseEntity.ok(updatedActor);
    }

    @DeleteMapping("/actor/remove/{id}")
    public boolean deleteActor(@PathVariable("id")short id)
    {
        try {
            actorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @GetMapping("/actors/name/{name}")
    List<Actor> findByName(@PathVariable("name")String name)
    {
      List<Actor> match =  actorRepository.findByName(name);
        if (match.isEmpty())
        { match = actorRepository.findSimilar(name);
        }
        return match;
    }


}