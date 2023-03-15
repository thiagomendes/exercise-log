package br.com.tmdev.exerciselog.controller;

import br.com.tmdev.exerciselog.dto.UserRequestDTO;
import br.com.tmdev.exerciselog.dto.UserResponseDTO;
import br.com.tmdev.exerciselog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("user_id") int userId) {
        UserResponseDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO newUser = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable("user_id") int userId,
                                                      @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(userId, userRequestDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user_id") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserResponseDTO> authenticateUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO authenticatedUser = userService.authenticateUser(userRequestDTO.getEmail(), userRequestDTO.getPassword());
        return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
    }
}