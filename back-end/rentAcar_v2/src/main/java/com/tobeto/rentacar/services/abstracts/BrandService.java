package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.request.Brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
     List<GetBrandListResponse> getAll();
     GetBrandResponse getById(int id);
     void    add(AddBrandRequest addBrandRequest);
     void    update(UpdateBrandRequest updateBrandRequest);
     void     delete(int id);
}
