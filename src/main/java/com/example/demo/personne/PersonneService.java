/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
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
                throw new IllegalStateException("Email");
                }

         PersonneRepository.save(personne);
           
    } 
   
  public void deletePersonne(long PersonneId){
      boolean exists = PersonneRepository.existsById(PersonneId);
      if (!exists) {
                throw new IllegalStateException("Personne avec Id:" + PersonneId + "n'existe pas");
                    }
      PersonneRepository.deleteById(PersonneId);
  }

//    
    @Transactional
    void updatePersonne(Long PersonneId, String nom, String prenom, String email) {
        Personne personne = PersonneRepository.findById(PersonneId)
                .orElseThrow(()-> new IllegalStateException("Personne avec Id:" + PersonneId + "n'existe pas"));
        
        if(nom != null &&
                nom.length()> 0 && !Objects.equals(personne.getNom(), nom)){
            personne.setNom(nom);
        }
        
        if(prenom != null &&
                prenom.length()> 0 && !Objects.equals(personne.getPrenom(), prenom)){
            personne.setPrenom(prenom);
        }
        
         if(email != null &&
                email.length()> 0 && !Objects.equals(personne.getEmail(), email)){
            personne.setEmail(email);
        }
         
    }
 
}
