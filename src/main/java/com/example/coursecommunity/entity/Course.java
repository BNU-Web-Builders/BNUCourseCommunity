package com.example.coursecommunity.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Course {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String cCode;

    @NotEmpty(message = "课程名不能为空")
    @Size(min=1,max = 100)
    @Column(nullable = false,length = 100)
    private String name;

    private Long orgId;

    @Column(length = 100)
    private String teacher;

    private Timestamp updateTime;

    @Column(length = 50)
    private String courseTime;

    @Column(length = 50)
    private String termTime;//学期时间

    public Course() {
    }

    public Course(String cCode, @NotEmpty(message = "课程名不能为空") @Size(min = 1, max = 100) String name, Long orgId, String teacher, Timestamp updateTime, String courseTime, String termTime) {
        this.cCode = cCode;
        this.name = name;
        this.orgId = orgId;
        this.teacher = teacher;
        this.updateTime = updateTime;
        this.courseTime = courseTime;
        this.termTime = termTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getTermTime() {
        return termTime;
    }

    public void setTermTime(String termTime) {
        this.termTime = termTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cCode='" + cCode + '\'' +
                ", name='" + name + '\'' +
                ", orgId=" + orgId +
                ", teacher='" + teacher + '\'' +
                ", updateTime=" + updateTime +
                ", courseTime='" + courseTime + '\'' +
                ", termTime='" + termTime + '\'' +
                '}';
    }
}
