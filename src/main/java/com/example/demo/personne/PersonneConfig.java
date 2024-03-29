/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.personne;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JEANNINE
 */
@Configuration
public class PersonneConfig {
    
    @Bean
    CommandLineRunner CommandLineRunner(PersonneRepository repository){
        return args ->{
         
        Personne mariam = new Personne(
        
        "AGNAYO",
        "mariam",
        "mariam@gmail.com",
        LocalDate.of(1993, Month.MARCH, 1)
         
         );
         
         Personne jeanne = new Personne(
        "ADOKOU",
        "jeanne",
        "jeannineadokou@gmail.com",
        LocalDate.of(2002, Month.JANUARY, 5)
        
         );
         
         Personne clotilde = new Personne(
        "SIAKU",
        "clotilde",
        "clotilde@gmail.com",
        LocalDate.of(2011, Month.APRIL, 18)
        
         );
         
         repository.saveAll(
                 List.of(mariam, jeanne, clotilde)
             );
        };
}
}
