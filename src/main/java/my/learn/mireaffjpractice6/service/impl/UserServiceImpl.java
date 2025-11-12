package my.learn.mireaffjpractice6.service.impl;

import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service //todo
public class UserServiceImpl implements UserService {
    @Override
    public Optional<UserDTO> createUser(CreateUserRequest userRequest) {
        return Optional.empty();
    }
}
