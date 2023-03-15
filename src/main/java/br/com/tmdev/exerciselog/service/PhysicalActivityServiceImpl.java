package br.com.tmdev.exerciselog.service;

import br.com.tmdev.exerciselog.converter.PhysicalActivityConverter;
import br.com.tmdev.exerciselog.dto.PhysicalActivityRequestDTO;
import br.com.tmdev.exerciselog.dto.PhysicalActivityResponseDTO;
import br.com.tmdev.exerciselog.exception.ResourceNotFoundException;
import br.com.tmdev.exerciselog.model.PhysicalActivity;
import br.com.tmdev.exerciselog.repository.PhysicalActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhysicalActivityServiceImpl implements PhysicalActivityService {

    @Autowired
    private PhysicalActivityRepository physicalActivityRepository;

    @Override
    public List<PhysicalActivityResponseDTO> getAllActivities() {
        List<PhysicalActivity> activities = physicalActivityRepository.findAll();
        return activities.stream()
                .map(PhysicalActivityConverter::physicalActivityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhysicalActivityResponseDTO getActivityById(int activityId) {
        PhysicalActivity activity = physicalActivityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + activityId));
        return PhysicalActivityConverter.physicalActivityToResponseDto(activity);
    }

    @Override
    public List<PhysicalActivityResponseDTO> getActivitiesByUserId(int userId) {
        List<PhysicalActivity> activities = physicalActivityRepository.findByUserId(userId);
        return activities.stream()
                .map(PhysicalActivityConverter::physicalActivityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhysicalActivityResponseDTO createActivity(PhysicalActivityRequestDTO activityDto) {
        PhysicalActivity activity = PhysicalActivityConverter.requestDtoToPhysicalActivity(activityDto);
        PhysicalActivity savedActivity = physicalActivityRepository.save(activity);
        return PhysicalActivityConverter.physicalActivityToResponseDto(savedActivity);
    }

    @Override
    public PhysicalActivityResponseDTO updateActivity(int activityId, PhysicalActivityRequestDTO activityDto) {
        PhysicalActivity existingActivity = physicalActivityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + activityId));

        existingActivity.setActivityType(activityDto.getActivityType());
        existingActivity.setIntensity(activityDto.getIntensity());
        existingActivity.setDuration(activityDto.getDuration());
        existingActivity.setDate(activityDto.getDate());

        PhysicalActivity updatedActivity = physicalActivityRepository.save(existingActivity);
        return PhysicalActivityConverter.physicalActivityToResponseDto(updatedActivity);
    }

    @Override
    public void deleteActivity(int activityId) {
        PhysicalActivity activity = physicalActivityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + activityId));
        physicalActivityRepository.delete(activity);
    }
}
