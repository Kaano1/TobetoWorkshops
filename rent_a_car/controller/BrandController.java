package com.tobeto.spring.b.controller;


import com.tobeto.spring.b.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.dtos.response.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

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
    public GetBrandListResponse getAll()
    {
        GetBrandListResponse dto = new GetBrandListResponse();
        dto.setNames(this.brandRepository.findAll());
        return dto;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id)
    {
        GetBrandResponse dto = new GetBrandResponse();
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        dto.setName(brand.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest)
    {
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        this.brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
    {
        Brand brandToUpdate = this.brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setId(updateBrandRequest.getId());
        brandToUpdate.setName(updateBrandRequest.getName());
        this.brandRepository.save(brandToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);
    }
}
