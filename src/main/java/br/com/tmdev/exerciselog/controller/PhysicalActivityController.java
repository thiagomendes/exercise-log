package br.com.tmdev.exerciselog.controller;

import br.com.tmdev.exerciselog.dto.PhysicalActivityRequestDTO;
import br.com.tmdev.exerciselog.dto.PhysicalActivityResponseDTO;
import br.com.tmdev.exerciselog.service.PhysicalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class PhysicalActivityController {

    @Autowired
    private PhysicalActivityService physicalActivityService;

    @GetMapping
    public ResponseEntity<List<PhysicalActivityResponseDTO>> getAllActivities() {
        return ResponseEntity.ok(physicalActivityService.getAllActivities());
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<PhysicalActivityResponseDTO> getActivityById(@PathVariable int activityId) {
        return ResponseEntity.ok(physicalActivityService.getActivityById(activityId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PhysicalActivityResponseDTO>> getActivitiesByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(physicalActivityService.getActivitiesByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<PhysicalActivityResponseDTO> createActivity(@RequestBody PhysicalActivityRequestDTO activityDto) {
        PhysicalActivityResponseDTO createdActivity = physicalActivityService.createActivity(activityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<PhysicalActivityResponseDTO> updateActivity(@PathVariable int activityId, @RequestBody PhysicalActivityRequestDTO activityDto) {
        return ResponseEntity.ok(physicalActivityService.updateActivity(activityId, activityDto));
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable int activityId) {
        physicalActivityService.deleteActivity(activityId);
        return ResponseEntity.noContent().build();
    }
}
