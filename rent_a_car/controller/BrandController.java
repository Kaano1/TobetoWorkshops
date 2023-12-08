package com.tobeto.spring.b.controller;


import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController
{
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository)
    {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll()
    {
        return ( this.brandRepository.findAll() );
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id)
    {
        return this.brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand)
    {
        this.brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody Brand brand)
    {
        brand.setId(1);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);
    }
}
