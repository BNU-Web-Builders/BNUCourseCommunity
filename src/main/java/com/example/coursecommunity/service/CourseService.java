package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Course;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    /**
     * 新增、编辑、保存课程
     *
     * @param course
     * @return
     */
    Course saveOrUpdateCourse(Course course);


    /**
     * 删除课程
     *
     * @param id
     */
    void removeCourse(Long id);

    /**
     * 根据id获取课程信息
     *
     * @param id
     * @return
     */
    Optional<Course> getCourseById(Long id);

    /**
     * 课程信息的模糊查询
     *
     * @param keyword
     * @return
     */
    List<Course> generateSearchForCourse(String keyword, Pageable pageable);

    /**
     * 课程信息的高级查询
     *
     * @param formation
     * @return
     */
    List<Course> advancedSearchForCourse(String formation, Pageable pageable);
}
