package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Family;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

}
