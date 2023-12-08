package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{  }
