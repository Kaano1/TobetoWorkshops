package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repository.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.request.Rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.request.Rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetRentalListResponse> getAll()
    {
        List<Rental> rentals = rentalRepository.findAll();
        return (rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetRentalListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetRentalResponse getById(int id)
    {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(rental, GetRentalResponse.class);
    }
    @Override
    public void    add(AddRentalRequest addRentalRequest)
    {
        Rental rental = modelMapperService.forRequest().map(addRentalRequest, Rental.class);
        rentalRepository.save(rental);
    }
    @Override
    public void    update(UpdateRentalRequest updateRentalRequest)
    {
        Rental rental = modelMapperService.forRequest().
                map(updateRentalRequest, Rental.class);
        rentalRepository.save(rental);
    }
    @Override
    public void     delete(int id)
    {
        Rental rental = rentalRepository.findById(id).orElseThrow();

        rentalRepository.delete(rental);
    }
}
