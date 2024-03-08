package com.example.sakiladb.repositories;

import com.example.sakiladb.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository <Actor , Short> {
    @Query("SELECT a FROM Actor a WHERE a.firstName = :name OR a.lastName = :name")
    List<Actor> findByName(String name);

    @Query(value = "Select * from Actor where concat(first_name,' ', last_name) like %:name%", nativeQuery = true)
    List<Actor> findSimilar(@Param("name") String name);

}
