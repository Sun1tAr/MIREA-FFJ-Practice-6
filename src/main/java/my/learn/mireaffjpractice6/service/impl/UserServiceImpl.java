package my.learn.mireaffjpractice6.service.impl;

import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.dto.responce.UserDTO;
import my.learn.mireaffjpractice6.exception.NotFoundException;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.repository.UserRepository;
import my.learn.mireaffjpractice6.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .notes(new ArrayList<>())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User was not found");
        }
        return user.get();
    }
}
