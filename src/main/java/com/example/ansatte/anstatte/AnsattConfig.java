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
            Ansatt s1 = new Ansatt("Per", "per@live.com", "male", "Stolmakergata", "9d", 1551, 90290980);
            Ansatt s2 = new Ansatt("Karin", "karin@gmail.com", "female", "Oslogata", "9d", 1551,4987815);


            // this Studenreposity interface will save the objects to the database
            repository.saveAll(
                    List.of(s1,s2)
            );

        };
    }
}



