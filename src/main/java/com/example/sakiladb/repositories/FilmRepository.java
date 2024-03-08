package com.example.sakiladb.repositories;

import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository  extends JpaRepository<Film, Short> {

  //  List<Film> findByActorId(Short actorId);
}
