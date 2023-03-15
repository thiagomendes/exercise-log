package br.com.tmdev.exerciselog.repository;

import br.com.tmdev.exerciselog.model.Goal;
import br.com.tmdev.exerciselog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    List<Goal> findByUser(User user);

}
