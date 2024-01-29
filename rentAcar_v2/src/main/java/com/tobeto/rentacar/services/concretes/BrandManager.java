package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.repository.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.request.Brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.request.Brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.response.Brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetBrandListResponse> getAll()
    {
        List<Brand> brands = brandRepository.findAll();
        return (brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetBrandListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetBrandResponse getById(int id)
    {
        Brand brand = brandRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(brand, GetBrandResponse.class);
    }
    @Override
    public void    add(AddBrandRequest addBrandRequest)
    {
        Brand brand = modelMapperService.forRequest().map(addBrandRequest, Brand.class);
        brandRepository.save(brand);
    }
    @Override
    public void    update(UpdateBrandRequest updateBrandRequest)
    {
        Brand brand = modelMapperService.forRequest().
                map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }
    @Override
    public void     delete(int id)
    {
        Brand brand = brandRepository.findById(id).orElseThrow();

        brandRepository.delete(brand);
    }
}
