package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.request.Color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.request.Color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.response.Color.GetColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorsController {
    private final ColorService colorService;

    @GetMapping("getAll")
    List<GetColorListResponse> getAll()
    {
        return colorService.getAll();
    }

    @GetMapping("getById/{id}")
    GetColorResponse getById(@PathVariable int id)
    {
        return colorService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddColorRequest addColorRequest)
    {
        colorService.add(addColorRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateColorRequest updateColorRequest) { colorService.update(updateColorRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        colorService.delete(id);
    }
}
