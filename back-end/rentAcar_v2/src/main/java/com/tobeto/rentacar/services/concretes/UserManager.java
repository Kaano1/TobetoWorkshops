package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.User;
import com.tobeto.rentacar.repository.UserRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.request.User.AddUserRequest;
import com.tobeto.rentacar.services.dtos.request.User.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.response.User.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.response.User.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetUserListResponse> getAll()
    {
        List<User> users = userRepository.findAll();
        return (users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetUserListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetUserResponse getById(int id)
    {
        User user = userRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(user, GetUserResponse.class);
    }
    @Override
    public void    add(AddUserRequest addUserRequest)
    {
        User user = modelMapperService.forRequest().map(addUserRequest, User.class);
        userRepository.save(user);
    }
    @Override
    public void    update(UpdateUserRequest updateUserRequest)
    {
        User user = modelMapperService.forRequest().
                map(updateUserRequest, User.class);
        user.setId(userRepository.findByFirstName(updateUserRequest.getFirstName()).getId());
        userRepository.save(user);
    }
    @Override
    public void     delete(int id)
    {
        User user = userRepository.findById(id).orElseThrow();

        userRepository.delete(user);
    }
}
