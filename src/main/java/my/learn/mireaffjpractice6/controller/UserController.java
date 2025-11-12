package my.learn.mireaffjpractice6.controller;

import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.exception.InternalServerException;
import my.learn.mireaffjpractice6.service.UserService;
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

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest userRequest) {
        Optional<UserDTO> user = userService.createUser(userRequest);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.CREATED);
        } else {
            throw new InternalServerException("User was not created");
        }
    }

}
