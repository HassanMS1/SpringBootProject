package com.example.ansatte.anstatte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnsattService {

    private final   AnsattRepository ansattRepository;

    @Autowired
    public AnsattService(AnsattRepository ansattRepository) {
        this.ansattRepository = ansattRepository;
    }

    public List<Ansatt> getAnsatte(){
        return ansattRepository.findAll();


//        return List.of(
//                new Ansatt(
//                        1L, "Hassan","hassan.shekh@gmail.com","male", "Stolmakergata","9D", 361
//
//                )
//        );
    }


    public void addNewAnsatt(Ansatt ansatt) {
        Optional<Ansatt> ansattBYEmail = ansattRepository.findAnsattByEmail(ansatt.getEmail());
        if (ansattBYEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        // here you could some valiation to student object from client etc

        ansattRepository.save(ansatt);
        System.out.println(ansatt);
    }

    public void deleteStudent(Long ansattid) {
        boolean exists = ansattRepository.existsById(ansattid);
        if(!exists) {
            throw new IllegalStateException("ansatt with id" + ansattid + " does not exist");
        }

        ansattRepository.deleteById(ansattid);

    }
}
