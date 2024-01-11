package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Brands;
import com.tobeto.spring.b.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarsRepository extends JpaRepository<Cars, Integer>
{
    boolean existsByModelName(String model_name);
}
