package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brands;
import com.tobeto.spring.b.entities.Cars;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.repositories.CarsRepository;
import com.tobeto.spring.b.services.abstracts.CarsService;
import com.tobeto.spring.b.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.spring.b.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsListResponse;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarsManager implements CarsService {

    private final CarsRepository carRepository;
    private final BrandRepository brandRepository;

    public List<GetCarsListResponse> getAll()
    {
        List<Cars> cars = carRepository.findAll();
        List<GetCarsListResponse> carsListResponses = new ArrayList<>();

        for (Cars car : cars)
        {
            GetCarsListResponse data = new GetCarsListResponse();

            data.setModelName(car.getModelName());
            data.setModelYear(car.getModeYear());

            carsListResponses.add(data);
        }
        return carsListResponses;
    }

    public GetCarsResponse getById(int id)
    {
        GetCarsResponse getCarsResponse = new GetCarsResponse();
        Cars car = this.carRepository.findById(id).orElseThrow();

        getCarsResponse.setModelName(car.getModelName());
        getCarsResponse.setModelYear(car.getModeYear());
        return getCarsResponse;
    }

    public void add(AddCarsRequest addCarsRequest)
    {
        if (carRepository.existsByModelName(addCarsRequest.getModelName()))
            throw new RuntimeException("Don't add same car");
        Cars car = new Cars();

        car.setModeYear(addCarsRequest.getModelYear());
        car.setModelName(addCarsRequest.getModelName());
        if (addCarsRequest.getBrandId() != -1)
        {
            Brands brands = brandRepository.findById(addCarsRequest.getBrandId()).orElseThrow();
            car.setBrand(brands);
        }
        this.carRepository.save(car);
    }

    public void update(UpdateCarsRequest car)
    {
        Cars cars = carRepository.findById(car.getId()).orElseThrow();
        cars.setId(car.getId());
        cars.setModelName(car.getModelName());
        cars.setModeYear(car.getModelYear());
        cars.setBrand(brandRepository.findById(car.getBrandId()).orElseThrow());
        carRepository.save(cars);
    }

    public void delete(int id)
    {
        Cars car = this.carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }
}
