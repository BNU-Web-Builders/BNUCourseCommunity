package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Comment;
import com.example.coursecommunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
