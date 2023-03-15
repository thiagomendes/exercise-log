package br.com.tmdev.exerciselog.converter;

import br.com.tmdev.exerciselog.dto.GoalRequestDTO;
import br.com.tmdev.exerciselog.dto.GoalResponseDTO;
import br.com.tmdev.exerciselog.model.Goal;
import br.com.tmdev.exerciselog.model.User;

public class GoalConverter {

    public static Goal goalRequestDtoToGoal(GoalRequestDTO goalRequestDTO, User user) {
        return Goal.builder()
                .user(user)
                .goalType(goalRequestDTO.getGoalType())
                .targetValue(goalRequestDTO.getTargetValue())
                .deadline(goalRequestDTO.getDeadline())
                .build();
    }

    public static GoalResponseDTO goalToGoalResponseDto(Goal goal) {
        return GoalResponseDTO.builder()
                .goalId(goal.getGoalId())
                .userId(goal.getUser().getUserId())
                .goalType(goal.getGoalType())
                .targetValue(goal.getTargetValue())
                .deadline(goal.getDeadline())
                .build();
    }
}
