package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Teacher;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    /**
     * 新增、编辑、保存教师信息
     * @param teacher
     * @return
     */
    Teacher saveOrUpdateTeacher(Teacher teacher);


    /**
     * 删除评论
     * @param id
     */
    void removeTeacher(Long id);

    /**
     * 根据id获取教师信息
     * @param id
     * @return
     */
    Optional<Teacher> getTeacherById(Long id);
}
