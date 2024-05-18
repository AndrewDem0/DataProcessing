package com.example.lab6.controller;

import com.example.lab6.entity.MyEntity;
import com.example.lab6.repos.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/lab6/api/my_entity")
public class MyController {

    @Autowired
    MyRepository myRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MyEntity postEntity(@RequestBody MyEntity myEntity){
        return myRepository.save(myEntity);
    }

    @GetMapping("/retrieve")
    public List<MyEntity> getEntities(){
        return myRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public MyEntity putEntity (@PathVariable Long id, @RequestBody MyEntity newEntity){
        MyEntity updateEntity = myRepository.findById(id)
                        .orElseThrow(()-> new ResourceAccessException("Not found MyEntity with id:"));
        updateEntity.setName(newEntity.getName());
        updateEntity.setAge(newEntity.getAge());
        return myRepository.save(updateEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity (@PathVariable Long id){
       myRepository.deleteById(id);
    }
}