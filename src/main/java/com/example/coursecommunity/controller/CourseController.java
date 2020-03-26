package com.example.coursecommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {
    //一、以下是页面
    /**
     * 课程详细信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detail/{id}")
    public ModelAndView courseDetail(
            @PathVariable("id")String id,
            Model model
    ){
        return new ModelAndView("course-page","Model",model);
    }


}
