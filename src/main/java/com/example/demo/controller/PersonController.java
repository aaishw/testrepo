package com.example.demo.controller;

import com.example.demo.Model.Person;
import com.example.demo.exception.ExceptionHandling;
import com.example.demo.repository.PersonRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/personcontroller")

public class PersonController {
    @Autowired
    PersonRepository modelRepository;

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){

        return modelRepository.findAll();
    }

    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody @Valid Person personData){
        return modelRepository.save(personData);
    }

    @GetMapping("/searchByID/{ID}")
    public Person getPersonByID(@PathVariable(value = "ID") Long ID ){
        return modelRepository.findById(ID).orElseThrow(()->new ExceptionHandling("Person", "ID", ID));
    }


    @DeleteMapping("/deleteByID/{ID}")
    public ResponseEntity<?> deleteByID(@PathVariable(value = "ID") Long ID ){
        Person person = modelRepository.findById(ID).orElseThrow(()->new ExceptionHandling("Person", "ID", ID));
        modelRepository.delete(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{ID}")
    public Person update(@PathVariable(value = "ID") Long ID, @RequestBody @Valid Person personData ){
        Person person = modelRepository.findById(ID).orElseThrow(()->new ExceptionHandling("Person", "ID", ID));
        person.setFName(personData.getFName());
        person.setLName(personData.getLName());
        person.setAge(personData.getAge());
        Person updatedPerson = modelRepository.save(person);
        return updatedPerson;


    }
}
