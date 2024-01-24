package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.BrandsService;
import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandsService brandsService;


    @GetMapping
    public List<GetBrandListResponse> getAll()
    {
        return brandsService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id)
    {
        return brandsService.getById(id);
    }

    @GetMapping("getByName")
    public List<GetBrandListResponse> getByName(@RequestParam String name,  @RequestParam int id)
    {
        return brandsService.getByName(name, id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest)
    {
        brandsService.add(addBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest othBrand)
    {
        brandsService.update(othBrand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        brandsService.delete(id);
    }

}
