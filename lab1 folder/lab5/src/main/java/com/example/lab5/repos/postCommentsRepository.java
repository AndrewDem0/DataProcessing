package com.example.lab5.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab5.entity.PostComment2;

//@RepositoryRestResource(collectionResourceRel = "user1", path = "user")
public interface postCommentsRepository extends JpaRepository<PostComment2, Long> {

//  List<User> findByLastName(@Param("name") String name);

}