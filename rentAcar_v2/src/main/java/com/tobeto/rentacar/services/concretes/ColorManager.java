package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.request.Color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.request.Color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetColorListResponse> getAll()
    {
        List<Color> colors = colorRepository.findAll();
        return (colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetColorListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetColorResponse getById(int id)
    {
        Color color = colorRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(color, GetColorResponse.class);
    }
    @Override
    public void    add(AddColorRequest addColorRequest)
    {
        Color color = modelMapperService.forRequest().map(addColorRequest, Color.class);
        colorRepository.save(color);
    }
    @Override
    public void    update(UpdateColorRequest updateColorRequest)
    {
        Color color = modelMapperService.forRequest().
                map(updateColorRequest, Color.class);
        colorRepository.save(color);
    }
    @Override
    public void     delete(int id)
    {
        Color color = colorRepository.findById(id).orElseThrow();

        colorRepository.delete(color);
    }
}
