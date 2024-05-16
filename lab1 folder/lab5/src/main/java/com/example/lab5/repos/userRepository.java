package com.example.lab5.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab5.entity.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@RepositoryRestResource(collectionResourceRel = "user1", path = "user")
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface userRepository extends JpaRepository<User, Integer> {

//  List<User> findByLastName(@Param("name") String name);

}