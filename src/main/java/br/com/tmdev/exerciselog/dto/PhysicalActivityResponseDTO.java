package br.com.tmdev.exerciselog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysicalActivityResponseDTO {
    private int activityId;
    private int userId;
    private String activityType;
    private String intensity;
    private int duration;
    private String date;
}
