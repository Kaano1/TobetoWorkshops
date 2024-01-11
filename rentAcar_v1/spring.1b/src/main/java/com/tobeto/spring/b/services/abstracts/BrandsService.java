package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;

import java.util.List;

public interface BrandsService {
    void delete(int id);
    void update(UpdateBrandRequest othBrand);
    void add(AddBrandRequest addBrandRequest);
    GetBrandResponse getById(int id);
    List<GetBrandListResponse> getAll();
    List<GetBrandListResponse> getByName(String name, int id);
}
