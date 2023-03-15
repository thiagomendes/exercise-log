package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.dto.PhysicalActivityRequestDTO;
import br.com.tmdev.exerciselog.dto.PhysicalActivityResponseDTO;

import java.util.List;

public interface PhysicalActivityService {
    List<PhysicalActivityResponseDTO> getAllActivities();

    PhysicalActivityResponseDTO getActivityById(int activityId);

    List<PhysicalActivityResponseDTO> getActivitiesByUserId(int userId);

    PhysicalActivityResponseDTO createActivity(PhysicalActivityRequestDTO activity);

    PhysicalActivityResponseDTO updateActivity(int activityId, PhysicalActivityRequestDTO activity);

    void deleteActivity(int activityId);
}
