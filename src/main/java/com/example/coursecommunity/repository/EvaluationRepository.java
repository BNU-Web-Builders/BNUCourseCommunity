package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Course;
import com.example.coursecommunity.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
