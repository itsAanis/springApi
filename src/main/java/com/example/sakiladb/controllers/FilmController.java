package com.example.sakiladb.controllers;


import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.entities.Film;
import com.example.sakiladb.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class FilmController {

    FilmRepository filmRepository;
    @Autowired
    public FilmController (FilmRepository filmRepository) {
       this.filmRepository = filmRepository;
    }

    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable("id")short id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "no film"));
    }

    @DeleteMapping("/film/remove/{id}")
    public boolean deleteFilm(@PathVariable("id")short id)
    {
        try {
            filmRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    @GetMapping("/film/actor/{id}")
    public List<Film> filmsByActorId (@PathVariable("id")short id)
    {
        return filmRepository.findByActorId(id);
    } */
}
