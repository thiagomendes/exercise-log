package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.dto.GoalRequestDTO;
import br.com.tmdev.exerciselog.dto.GoalResponseDTO;
import br.com.tmdev.exerciselog.model.Goal;

import java.util.List;

public interface GoalService {
    List<GoalResponseDTO> getAllGoals();

    GoalResponseDTO getGoalById(int goalId);

    List<GoalResponseDTO> getGoalsByUserId(int userId);

    GoalResponseDTO createGoal(GoalRequestDTO goal);

    GoalResponseDTO updateGoal(int goalId, GoalRequestDTO goal);

    void deleteGoal(int goalId);
}
