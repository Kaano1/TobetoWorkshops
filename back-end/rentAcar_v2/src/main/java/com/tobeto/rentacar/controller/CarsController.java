package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.request.Car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.request.Car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @GetMapping("getAll")
    List<GetCarListResponse> getAll()
    {
        return carService.getAll();
    }

    @GetMapping("getById/{id}")
    GetCarResponse getById(@PathVariable int id)
    {
        return carService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddCarRequest addCarRequest)
    {
        carService.add(addCarRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateCarRequest updateCarRequest) { carService.update(updateCarRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        carService.delete(id);
    }
}
