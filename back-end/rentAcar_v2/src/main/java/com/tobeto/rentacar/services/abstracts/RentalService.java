package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.request.Rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.response.Rental.GetRentalResponse;

import java.util.List;

public interface RentalService {
     List<GetRentalListResponse> getAll();
     GetRentalResponse getById(int id);
     void    add(AddRentalRequest addRentalRequest);
     void    update(UpdateRentalRequest updateRentalRequest);
     void     delete(int id);
}
