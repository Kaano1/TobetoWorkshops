package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brands, Integer> {
    List<Brands>    findByName(String name);

    //@Query("SELECT b FROM Brands b where  b.name like %:name%")
    //List<Brands> search(String name);

    //@Query(value = "SELECT * FROM brands where name like %:name%", nativeQuery = true)
    //List<Brands> search2(String name);
}
