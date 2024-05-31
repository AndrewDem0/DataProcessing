package com.example.lab6.repos;

import com.example.lab6.entity.Broniks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "Broniks", path = "Broniks")
public interface MyRepository extends JpaRepository<Broniks, Long> {
}
