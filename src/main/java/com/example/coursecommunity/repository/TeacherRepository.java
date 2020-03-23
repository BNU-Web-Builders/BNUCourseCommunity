package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Evaluation;
import com.example.coursecommunity.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
