package com.example.sakiladb.controllers.input;
 import jakarta.validation.constraints.NotNull;
 import jakarta.validation.constraints.Size;
 import  lombok.Data;


 @Data
public class ActorInput {
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
}
