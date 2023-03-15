package br.com.tmdev.exerciselog.converter;

import br.com.tmdev.exerciselog.dto.UserRequestDTO;
import br.com.tmdev.exerciselog.dto.UserResponseDTO;
import br.com.tmdev.exerciselog.model.User;

public class UserConverter {

    public static User userRequestDtoToUser(UserRequestDTO userRequestDTO) {
        return User.builder()
                .name(userRequestDTO.getName())
                .age(userRequestDTO.getAge())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .build();
    }

    public static UserResponseDTO userToUserResponseDto(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }
}
