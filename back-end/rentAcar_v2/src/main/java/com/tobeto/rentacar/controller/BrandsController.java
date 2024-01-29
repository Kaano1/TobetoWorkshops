package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.request.Brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.request.Brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping("getAll")
    List<GetBrandListResponse> getAll()
    {
        return brandService.getAll();
    }

    @GetMapping("getById/{id}")
    GetBrandResponse getById(@PathVariable int id)
    {
        return brandService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddBrandRequest addBrandRequest)
    {
        brandService.add(addBrandRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) { brandService.update(updateBrandRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        brandService.delete(id);
    }

}
