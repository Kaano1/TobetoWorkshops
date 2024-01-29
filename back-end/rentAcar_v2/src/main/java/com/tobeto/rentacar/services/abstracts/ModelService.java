package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.request.Model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelResponse;

import java.util.List;

public interface ModelService {
    
    List<GetModelListResponse> getAll();
     GetModelResponse getById(int id);
     void    add(AddModelRequest addModelRequest);
     void    update(UpdateModelRequest updateModelRequest);
     void     delete(int id);
}
