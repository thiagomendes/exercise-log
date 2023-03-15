package br.com.tmdev.exerciselog.dto;

import br.com.tmdev.exerciselog.model.Goal;
import br.com.tmdev.exerciselog.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalRequestDTO {
    private Integer userId;
    private String goalType;
    private Integer targetValue;
    private LocalDate deadline;
}
