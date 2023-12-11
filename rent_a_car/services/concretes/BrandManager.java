package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService
{
    private final BrandRepository brandRepository;
    @Override
    public GetBrandListResponse getAll()
    {
        GetBrandListResponse dto = new GetBrandListResponse();
        dto.setNames(this.brandRepository.findAll());
        return dto;
    }
    @Override
    public GetBrandResponse getById(int id)
    {
        GetBrandResponse dto = new GetBrandResponse();
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        dto.setName(brand.getName());
        return dto;
    }

    @Override
    public void add(AddBrandRequest addBrandRequest)
    {
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest)
    {
        Brand brandToUpdate = this.brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setId(updateBrandRequest.getId());
        brandToUpdate.setName(updateBrandRequest.getName());
        this.brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(int id)
    {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);
    }
}
