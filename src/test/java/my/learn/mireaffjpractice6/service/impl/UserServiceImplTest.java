package my.learn.mireaffjpractice6.service.impl;

import my.learn.mireaffjpractice6.dto.request.CreateNoteRequest;
import my.learn.mireaffjpractice6.dto.request.CreateUserRequest;
import my.learn.mireaffjpractice6.exception.NotFoundException;
import my.learn.mireaffjpractice6.model.User;
import my.learn.mireaffjpractice6.repository.UserRepository;
import my.learn.mireaffjpractice6.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        CreateUserRequest req = new CreateUserRequest();
        req.setName("TestUser");
        req.setEmail("testuser@mail.com");

        User afterSaving = User.builder()
                .id(1L)
                .name(req.getName())
                .email(req.getEmail())
                .notes(new ArrayList<>())
                .build();

        when(userRepository.save(any(User.class))).thenReturn(afterSaving);

        User user = userService.createUser(req);
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals(req.getName(), user.getName());
        assertEquals(req.getEmail(), user.getEmail());
    }

    @Test
    public void getUserTest_userFound() {
        Long id = 1L;
        User user = User.builder()
                .id(id)
                .name("TestUser")
                .email("testuser@mail.com")
                .notes(new ArrayList<>())
                .build();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User userById = userService.findUserById(id);
        assertNotNull(userById);
        assertEquals(user.getId(), userById.getId());
        assertEquals(user.getName(), userById.getName());
        assertEquals(user.getEmail(), userById.getEmail());
    }

    @Test
    public void getUserTest_userNotFound() {
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,  () -> userService.findUserById(id));
    }

}