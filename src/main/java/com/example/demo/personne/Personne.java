/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;


/**
 *
 * @author JEANNINE
 */
@Entity
@Table
public class Personne {
        @Id
   
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Personne() {
    }

    public Personne(Long id, String nom,String prenom, String email, LocalDate dob) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dob = dob;
   
    }

    public Personne(String nom,String prenom, String email, LocalDate dob) {
       this.nom = nom;
       this.prenom = prenom;
        this.email = email;
        this.dob = dob;
       
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dob=" + dob + ", age=" + age + "ans" + '}'+'\n' ;
    }

   

}
