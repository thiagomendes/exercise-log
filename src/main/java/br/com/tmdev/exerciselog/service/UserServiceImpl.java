package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.converter.UserConverter;
import br.com.tmdev.exerciselog.dto.UserRequestDTO;
import br.com.tmdev.exerciselog.dto.UserResponseDTO;
import br.com.tmdev.exerciselog.exception.InvalidPasswordException;
import br.com.tmdev.exerciselog.exception.ResourceNotFoundException;
import br.com.tmdev.exerciselog.model.User;
import br.com.tmdev.exerciselog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserConverter::userToUserResponseDto).collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return UserConverter.userToUserResponseDto(user);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = UserConverter.userRequestDtoToUser(userRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return UserConverter.userToUserResponseDto(savedUser);
    }

    public UserResponseDTO updateUser(int userId, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        existingUser.setName(userRequestDTO.getName());
        existingUser.setAge(userRequestDTO.getAge());
        existingUser.setEmail(userRequestDTO.getEmail());
        existingUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        User updatedUser = userRepository.save(existingUser);
        return UserConverter.userToUserResponseDto(updatedUser);
    }

    public void deleteUser(int userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.deleteById(userId);
    }

    public UserResponseDTO authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return UserConverter.userToUserResponseDto(user);
        } else {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
