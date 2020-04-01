package com.example.coursecommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Teacher {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String tCode;

    @NotEmpty(message = "教师姓名不能为空")
    @Size(min = 1, max = 16)
    @Column(nullable = false, length = 16)
    private String name;

    @Column(length = 10)
    private String title;

    private Long orgId;

    public Teacher() {
    }

    public Teacher(String tCode, @NotEmpty(message = "教师姓名不能为空") @Size(min = 1, max = 16) String name, String title, Long orgId) {
        this.tCode = tCode;
        this.name = name;
        this.title = title;
        this.orgId = orgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tCode='" + tCode + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}
