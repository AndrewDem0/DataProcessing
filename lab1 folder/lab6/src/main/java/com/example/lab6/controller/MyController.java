package com.example.lab6.controller;

import com.example.lab6.entity.Broniks;
import com.example.lab6.repos.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lab6/api/Broniks")
public class MyController {

    @Autowired
    MyRepository myRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Broniks postEntity(@RequestBody Broniks broniks) {
        return myRepository.save(broniks);
    }

    @GetMapping("")
    public List<Broniks> getEntities() {
        return myRepository.findAll();
    }

    @PutMapping("/{id}")
    public Broniks putEntity(@PathVariable long id, @RequestBody Broniks newEntity) {
        Broniks updatedEntity = myRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Not found Broniks with id: " + id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setDescription(newEntity.getDescription());
        updatedEntity.setImg(newEntity.getImg());
        return myRepository.save(updatedEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntity(@PathVariable long id) {
        if (!myRepository.existsById(id)) {
            throw new ResourceAccessException("Not found Broniks with id: " + id);
        }
        myRepository.deleteById(id);
    }
}