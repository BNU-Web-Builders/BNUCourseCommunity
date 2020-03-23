package com.example.coursecommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Comment {//点赞和踩尚未实现
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long eId;

    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp createTime;//评价创建时间,自动入库

    @NotEmpty(message = "评价文字内容不能为空")
    @Size(min = 2,max = 300)
    @Column(nullable = false)
    private String content;

    public Comment() {
    }

    public Comment(Long userId, Long eId, Timestamp createTime, @NotEmpty(message = "评价文字内容不能为空") @Size(min = 2, max = 300) String content) {
        this.userId = userId;
        this.eId = eId;
        this.createTime = createTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", eId=" + eId +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }
}
