package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;

public interface BrandService {
    GetBrandListResponse getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
