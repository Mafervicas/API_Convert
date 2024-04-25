package com.ford.numbers.repositories;

import com.ford.numbers.entities.NumberToConvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Just To make it similar to a microservice.
@Repository
public interface NumberRepository extends JpaRepository<NumberToConvert, Integer> {
}
