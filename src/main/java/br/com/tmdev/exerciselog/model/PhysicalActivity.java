package br.com.tmdev.exerciselog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "physical_activities")
public class PhysicalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "intensity")
    private String intensity;

    @Column(name = "duration")
    private int duration;

    @Column(name = "date")
    private String date;
}