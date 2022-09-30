/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JEANNINE
 */
@Repository
public interface PersonneRepository extends JpaRepository <Personne, Long>{
    
    // SELECT * FROM personne WHERE email= ?
    @Query ("SELECT p FROM Personne p WHERE email= ?1")
    Optional<Personne> findPersonneByEmail(String email);
    
}
