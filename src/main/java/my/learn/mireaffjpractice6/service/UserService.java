package my.learn.mireaffjpractice6.service;

import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> createUser(CreateUserRequest userRequest);

}
