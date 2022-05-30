package com.example.ansatte.anstatte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.MAY;
@Configuration
public class AnsattConfig {

    @Bean // this makes so it runs automatically when the app is run
    CommandLineRunner commandLineRunner( AnsattRepository repository){
        return args -> {
            Ansatt s1 = new Ansatt("Hassan", "hassan@gmail.com", "male", "Stolmakergata", "9d", 1551, 90290980);
            Ansatt s2 = new Ansatt("Hassan", "hassan@gmail.com", "male", "Stolmakergata", "9d", 1551,9024984);


            // this Studenreposity interface will save the objects to the database
            repository.saveAll(
                    List.of(s1,s2)
            );

        };
    }
}



