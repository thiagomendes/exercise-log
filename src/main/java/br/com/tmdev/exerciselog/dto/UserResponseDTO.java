package br.com.tmdev.exerciselog.dto;

import br.com.tmdev.exerciselog.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private int userId;
    private String name;
    private int age;
    private String email;
}
