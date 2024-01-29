package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.request.User.AddUserRequest;
import com.tobeto.rentacar.services.dtos.request.User.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.response.User.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.response.User.GetUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("getAll")
    List<GetUserListResponse> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("getById/{id}")
    GetUserResponse getById(@PathVariable int id)
    {
        return userService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddUserRequest addUserRequest)
    {
        userService.add(addUserRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateUserRequest updateUserRequest) { userService.update(updateUserRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        userService.delete(id);
    }
}
