package com.example.lab5.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab5.entity.Post2;

//@RepositoryRestResource(collectionResourceRel = "user1", path = "user")
public interface postRepository extends JpaRepository<Post2, Long> {

//  List<User> findByLastName(@Param("name") String name);

}