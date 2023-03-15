package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.converter.GoalConverter;
import br.com.tmdev.exerciselog.dto.GoalRequestDTO;
import br.com.tmdev.exerciselog.dto.GoalResponseDTO;
import br.com.tmdev.exerciselog.exception.ResourceNotFoundException;
import br.com.tmdev.exerciselog.model.Goal;
import br.com.tmdev.exerciselog.model.User;
import br.com.tmdev.exerciselog.repository.GoalRepository;
import br.com.tmdev.exerciselog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GoalResponseDTO> getAllGoals() {
        return goalRepository.findAll()
                .stream()
                .map(GoalConverter::goalToGoalResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoalResponseDTO getGoalById(int goalId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));
        return GoalConverter.goalToGoalResponseDto(goal);
    }

    @Override
    public List<GoalResponseDTO> getGoalsByUserId(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return goalRepository.findByUser(user)
                .stream()
                .map(GoalConverter::goalToGoalResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoalResponseDTO createGoal(GoalRequestDTO goalRequestDTO) {
        User user = userRepository.findById(goalRequestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + goalRequestDTO.getUserId()));
        Goal goal = GoalConverter.goalRequestDtoToGoal(goalRequestDTO, user);
        goalRepository.save(goal);
        return GoalConverter.goalToGoalResponseDto(goal);
    }

    @Override
    public GoalResponseDTO updateGoal(int goalId, GoalRequestDTO goalRequestDTO) {
        Goal existingGoal = goalRepository.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));

        existingGoal.setGoalType(goalRequestDTO.getGoalType());
        existingGoal.setTargetValue(goalRequestDTO.getTargetValue());
        existingGoal.setDeadline(goalRequestDTO.getDeadline());

        goalRepository.save(existingGoal);
        return GoalConverter.goalToGoalResponseDto(existingGoal);
    }

    @Override
    public void deleteGoal(int goalId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));
        goalRepository.delete(goal);
    }
}
