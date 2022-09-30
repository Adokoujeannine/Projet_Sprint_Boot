/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author JEANNINE
 */
@Service
public class PersonneService {
         private final PersonneRepository PersonneRepository;
     
     @Autowired
      public PersonneService(PersonneRepository PersonneRepository){
        this.PersonneRepository = PersonneRepository;
    }
     public List<Personne> getPersonnes(){
	return PersonneRepository.findAll();
         }
     
    public void addNewPersonne(Personne personne){
         Optional<Personne> personneOptional = PersonneRepository.findPersonneByEmail(personne.getEmail());
                if (personneOptional.isPresent()) {
                throw new IllegalStateException("email taken");
                }

         PersonneRepository.save(personne);
            
        System.out.println(personne);
    } 
    
  public void deletePersonne(long PersonneId){}
//    
//    public Personne modifierPersonne(Personne personne){}
//    
}
