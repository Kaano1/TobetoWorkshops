package com.tobeto.spring.b.controller;


import com.tobeto.spring.b.services.concretes.BrandManager;
import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/brands")
public class BrandController
{
    private final BrandManager brandManager;

    public BrandController(BrandManager brandManager)
    {
        this.brandManager = brandManager;
    }

    @GetMapping
    public GetBrandListResponse getAll()
    {
        return brandManager.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id)
    {
        return brandManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest)
    {
        brandManager.add(addBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
    {
        brandManager.update(updateBrandRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        brandManager.delete(id);
    }
}
