/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JEANNINE
 */
@RestController
@RequestMapping(path="api/p1/personne")
public class PersonneController {
        @Autowired
    private final PersonneService PersonneService;
    
    public PersonneController(PersonneService PersonneService){
        this.PersonneService= PersonneService;
    }
    
    @GetMapping  
         public List<Personne> getPersonnes(){
             return PersonneService.getPersonnes();
         }
         
      @PostMapping   
    public void RegisterNewPersonne(@RequestBody Personne personne){
        PersonneService.addNewPersonne(personne);
    }

    @DeleteMapping(path = "{PersonneId}")
    public void deletePersonne(@PathVariable ("PersonneId") Long PersonneId){
        PersonneService.deletePersonne(PersonneId);
    }
}
