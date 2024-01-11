package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.CarsService;
import com.tobeto.spring.b.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.spring.b.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsListResponse;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class CarsController {
    private final CarsService carsService;


    @GetMapping
    public List<GetCarsListResponse> getAll()
    {
        return carsService.getAll();
    }

    @GetMapping("{id}")
    public GetCarsResponse getById(@PathVariable int id)
    {
        return carsService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarsRequest addCarsRequest)
    {
        carsService.add(addCarsRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCarsRequest car)
    {
        carsService.update(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        carsService.delete(id);
    }
}
