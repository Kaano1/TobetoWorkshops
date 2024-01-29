package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.User.AddUserRequest;
import com.tobeto.rentacar.services.dtos.request.User.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.response.User.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.response.User.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();

    GetUserResponse getById(int id);
    void    add(AddUserRequest addUserRequest);
    void    update(UpdateUserRequest updateUserRequest);
    void    delete(int id);
}
