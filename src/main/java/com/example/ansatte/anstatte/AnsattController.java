package com.example.ansatte.anstatte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ansatte")

public class AnsattController {

    private final AnsattService ansattService;

    @Autowired
    public AnsattController(AnsattService ansattService) {
        this.ansattService = ansattService;
    }

    @GetMapping
    public List<Ansatt> getAnsatte(){
        return ansattService.getAnsatte();

    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        HttpHeaders header = new HttpHeaders();
        header.add("Decs", "This is the header value");
        return new ResponseEntity<String>("Hello World!",  header, HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin (origins = "http://127.0.0.1:5500")
    public void registerNewAnsatt(@RequestBody Ansatt ansatt)
    // @RequestBody is mapping the incomming object from the Client to class student
    {
        ansattService.addNewAnsatt(ansatt);
    }

    @DeleteMapping(path = "{ansattId}") // student id is value thats passed from client
    public void deleteStudent(@PathVariable("ansattId") Long id){
        ansattService.deleteStudent(id);

    }

    @DeleteMapping("/hello/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        ansattService.deleteStudent(id);
        return "Item deleted";
    }

}
