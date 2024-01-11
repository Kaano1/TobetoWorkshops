package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brands;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandsService;
import com.tobeto.spring.b.services.dtos.request.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.request.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.response.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandsManager implements BrandsService {
    private final BrandRepository brandRepository;

    @Override
    public List<GetBrandListResponse> getAll()
    {
        List<Brands> brands = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();

        for (Brands brand : brands)
        {
            GetBrandListResponse br = new GetBrandListResponse();

            br.setId(brand.getId());
            br.setName(brand.getName());

            getBrandListResponses.add(br);
        }

        return getBrandListResponses;
    }

    @Override
    public GetBrandResponse getById(int id)
    {
        GetBrandResponse getBrandResponse = new GetBrandResponse();
        Brands brand = brandRepository.findById(id).orElseThrow();

        getBrandResponse.setName(brand.getName());
        return getBrandResponse;
    }

    @Override
    public void add(AddBrandRequest addBrandRequest)
    {
        List<Brands> brandsWithSameName = brandRepository.findByName(addBrandRequest.getName().trim());

        if (!brandsWithSameName.isEmpty())
            throw new RuntimeException("You do not have to add two same name");

        Brands brand = new Brands();

        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest othBrand)
    {
        Brands brand = brandRepository.findById(othBrand.getId()).orElseThrow();
        brand.setId(othBrand.getId());
        brand.setName(othBrand.getName());
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id)
    {
        Brands brand = this.brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);
    }

    @Override
    public List<GetBrandListResponse> getByName(String name, int id)
    {
        List<Brands> tmp = brandRepository.findByName(name);
        List<GetBrandListResponse> result = new ArrayList<>();

        for (Brands t : tmp)
        {
            GetBrandListResponse brand = new GetBrandListResponse();
            brand.setName(t.getName());
            result.add(brand);
        }
        return result;
    }
}
