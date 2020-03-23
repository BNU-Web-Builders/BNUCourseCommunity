package com.example.coursecommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Organization {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "学院机构名字不能为空")
    @Size(min=2,max = 50)
    @Column(nullable = false,length = 50)
    private String name;

    @NotEmpty(message = "学院机构官网不能为空")
    @Size(min=1,max = 200)
    @Column(nullable = false,length = 200)
    private String url;

    private boolean isSchool;

    public Organization() {
    }

    public Organization(@NotEmpty(message = "学院机构名字不能为空") @Size(min = 2, max = 50) String name, @NotEmpty(message = "学院机构官网不能为空") @Size(min = 1, max = 200) String url, boolean isSchool) {
        this.name = name;
        this.url = url;
        this.isSchool = isSchool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSchool() {
        return isSchool;
    }

    public void setSchool(boolean school) {
        isSchool = school;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", isSchool=" + isSchool +
                '}';
    }
}
