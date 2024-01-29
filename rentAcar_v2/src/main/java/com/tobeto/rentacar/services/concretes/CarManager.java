package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.request.Car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.request.Car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final ColorRepository colorRepository;
    private final ModelRepository modelRepository;

    @Override
    public List<GetCarListResponse> getAll()
    {
        List<Car> cars = carRepository.findAll();
        return (cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetCarListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetCarResponse getById(int id)
    {
        Car car = carRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(car, GetCarResponse.class);
    }
    @Override
    public void    add(AddCarRequest addCarRequest)
    {
        Car car = modelMapperService.forRequest().map(addCarRequest, Car.class);
        if (addCarRequest.getColorId() != 0)
        {
            Color color = colorRepository.findById(addCarRequest.getColorId()).orElseThrow();
            car.setColor(color);
        }
        if (addCarRequest.getModelId() != 0)
        {
            Model model = modelRepository.findById(addCarRequest.getModelId()).orElseThrow();
            car.setModel(model);
        }
        carRepository.save(car);
    }
    @Override
    public void    update(UpdateCarRequest updateCarRequest)
    {
        Car car = modelMapperService.forRequest().
                map(updateCarRequest, Car.class);
        carRepository.save(car);
    }
    @Override
    public void     delete(int id)
    {
        Car car = carRepository.findById(id).orElseThrow();

        carRepository.delete(car);
    }
}
