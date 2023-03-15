package br.com.tmdev.exerciselog.dto;

import br.com.tmdev.exerciselog.model.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalResponseDTO {
    private int goalId;
    private int userId;
    private String goalType;
    private int targetValue;
    private LocalDate deadline;
}
