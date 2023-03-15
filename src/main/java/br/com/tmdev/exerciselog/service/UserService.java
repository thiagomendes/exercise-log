package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.dto.UserRequestDTO;
import br.com.tmdev.exerciselog.dto.UserResponseDTO;
import br.com.tmdev.exerciselog.model.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(int userId);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(int userId, UserRequestDTO userRequestDTO);

    void deleteUser(int userId);

    UserResponseDTO authenticateUser(String email, String password);
}
