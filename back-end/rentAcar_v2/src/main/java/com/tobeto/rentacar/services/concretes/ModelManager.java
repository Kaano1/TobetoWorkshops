package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.request.Model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.request.Model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetModelListResponse> getAll()
    {
        List<Model> models = modelRepository.findAll();
        return (models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetModelListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetModelResponse getById(int id)
    {
        Model model = modelRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(model, GetModelResponse.class);
    }
    @Override
    public void    add(AddModelRequest addModelRequest)
    {
        Model model = modelMapperService.forRequest().map(addModelRequest, Model.class);
        modelRepository.save(model);
    }
    @Override
    public void    update(UpdateModelRequest updateModelRequest)
    {
        Model model = modelMapperService.forRequest().
                map(updateModelRequest, Model.class);
        modelRepository.save(model);
    }
    @Override
    public void     delete(int id)
    {
        Model model = modelRepository.findById(id).orElseThrow();

        modelRepository.delete(model);
    }
}
