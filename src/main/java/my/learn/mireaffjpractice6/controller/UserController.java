package my.learn.mireaffjpractice6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.exception.InternalServerException;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.service.UserService;
import my.learn.mireaffjpractice6.util.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserRequest userRequest) {
        User user = userService.createUser(userRequest);
        UserDTO userDTO = mapper.mapToDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

}
