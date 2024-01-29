package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.request.Color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorResponse;

import java.util.List;


public interface ColorService {
     List<GetColorListResponse> getAll();
     GetColorResponse getById(int id);
     void    add(AddColorRequest addColorRequest);
     void    update(UpdateColorRequest updateColorRequest);
     void     delete(int id);
}
