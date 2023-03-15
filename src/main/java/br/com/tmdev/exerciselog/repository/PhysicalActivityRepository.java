package br.com.tmdev.exerciselog.repository;

import br.com.tmdev.exerciselog.model.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Integer> {
    List<PhysicalActivity> findByUserId(int userId);
}