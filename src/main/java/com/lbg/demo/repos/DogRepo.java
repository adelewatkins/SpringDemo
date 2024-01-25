package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Dog;

public interface DogRepo extends JpaRepository<Dog, Integer> {

}
