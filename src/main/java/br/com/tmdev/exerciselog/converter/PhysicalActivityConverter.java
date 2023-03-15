package br.com.tmdev.exerciselog.converter;

import br.com.tmdev.exerciselog.dto.PhysicalActivityRequestDTO;
import br.com.tmdev.exerciselog.dto.PhysicalActivityResponseDTO;
import br.com.tmdev.exerciselog.model.PhysicalActivity;

public class PhysicalActivityConverter {

    public static PhysicalActivity requestDtoToPhysicalActivity(PhysicalActivityRequestDTO dto) {
        return PhysicalActivity.builder()
                .activityType(dto.getActivityType())
                .intensity(dto.getIntensity())
                .duration(dto.getDuration())
                .date(dto.getDate())
                .build();
    }

    public static PhysicalActivityResponseDTO physicalActivityToResponseDto(PhysicalActivity activity) {
        return PhysicalActivityResponseDTO.builder()
                .activityId(activity.getActivityId())
                .userId(activity.getUserId())
                .activityType(activity.getActivityType())
                .intensity(activity.getIntensity())
                .duration(activity.getDuration())
                .date(activity.getDate())
                .build();
    }
}
