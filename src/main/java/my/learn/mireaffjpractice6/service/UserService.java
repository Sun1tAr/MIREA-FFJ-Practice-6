package my.learn.mireaffjpractice6.service;

import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(CreateUserRequest userRequest);
    User findUserById(Long id);

}
