package com.example.sakiladb;


import com.example.sakiladb.controllers.ActorController;
import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.repositories.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ActorControllerStepDef {
    @Mock
    private ActorRepository mockActorRepository;
    private  Actor expectedActor = new Actor();
    private Actor returnedActor;
    private AutoCloseable closeable;

    public ActorControllerStepDef() {
        mockActorRepository = mock(ActorRepository.class);
    }



    @Given("an actor with the provided Id {short} exists")
        public void givenActorWithIdExists(short id) {
        expectedActor.setId(id);
        expectedActor.setFirstName("John");
        expectedActor.setLastName("Doe");
        when(mockActorRepository.findById(id)).thenReturn(Optional.of(expectedActor));
        }

    @When("a get request is made for the actor with ID {short}")
        public void whenRequestedWithId(Short id) {
        ActorController actorController = new ActorController(mockActorRepository);
        returnedActor = actorController.getActorById(id);
    }

    @Then("an Actor is returned")
    public void anActorIsReturned() {
        assertNotNull(returnedActor);
        assertEquals(expectedActor.getFirstName(), returnedActor.getFirstName());
        assertEquals(expectedActor.getLastName(), returnedActor.getLastName());
    }


//i guess we create some values of waht we would expect if someone
    // used the method .
    // then we compare it to whats returned to what we except to be returned.
    // what can we mock a controller ?

}
