package com.example.ansatte.anstatte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnsattRepository extends JpaRepository<Ansatt,Long> {
    Optional<Ansatt> findAnsattByEmail(String email);



}
