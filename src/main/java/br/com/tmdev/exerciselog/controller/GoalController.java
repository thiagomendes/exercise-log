package br.com.tmdev.exerciselog.controller;

import br.com.tmdev.exerciselog.dto.GoalRequestDTO;
import br.com.tmdev.exerciselog.dto.GoalResponseDTO;
import br.com.tmdev.exerciselog.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<GoalResponseDTO>> getAllGoals() {
        List<GoalResponseDTO> goals = goalService.getAllGoals();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<GoalResponseDTO> getGoalById(@PathVariable int goalId) {
        GoalResponseDTO goal = goalService.getGoalById(goalId);
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GoalResponseDTO>> getGoalsByUserId(@PathVariable int userId) {
        List<GoalResponseDTO> goals = goalService.getGoalsByUserId(userId);
        return ResponseEntity.ok(goals);
    }

    @PostMapping
    public ResponseEntity<GoalResponseDTO> createGoal(@RequestBody GoalRequestDTO goalRequestDTO) {
        GoalResponseDTO createdGoal = goalService.createGoal(goalRequestDTO);
        return ResponseEntity.ok(createdGoal);
    }

    @PutMapping("/{goalId}")
    public ResponseEntity<GoalResponseDTO> updateGoal(@PathVariable int goalId, @RequestBody GoalRequestDTO goalRequestDTO) {
        GoalResponseDTO updatedGoal = goalService.updateGoal(goalId, goalRequestDTO);
        return ResponseEntity.ok(updatedGoal);
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable int goalId) {
        goalService.deleteGoal(goalId);
        return ResponseEntity.noContent().build();
    }
}