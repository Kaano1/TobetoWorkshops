package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.request.Rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.request.Rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController {
    private final RentalService rentalService;

    @GetMapping("getAll")
    List<GetRentalListResponse> getAll()
    {
        return rentalService.getAll();
    }

    @GetMapping("getById/{id}")
    GetRentalResponse getById(@PathVariable int id)
    {
        return rentalService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddRentalRequest addRentalRequest)
    {
        rentalService.add(addRentalRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) { rentalService.update(updateRentalRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        rentalService.delete(id);
    }
}
