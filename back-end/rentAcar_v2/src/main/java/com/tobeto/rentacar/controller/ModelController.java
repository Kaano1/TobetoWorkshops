package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.request.Model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.request.Model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.response.Model.GetModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("getAll")
    List<GetModelListResponse> getAll()
    {
        return modelService.getAll();
    }

    @GetMapping("getById/{id}")
    GetModelResponse getById(@PathVariable int id)
    {
        return modelService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddModelRequest addModelRequest)
    {
        modelService.add(addModelRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateModelRequest updateModelRequest) { modelService.update(updateModelRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        modelService.delete(id);
    }
}
