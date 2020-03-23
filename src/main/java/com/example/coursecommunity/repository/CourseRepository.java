package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Course;
import com.example.coursecommunity.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
