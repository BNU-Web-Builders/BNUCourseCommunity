package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Comment;
import com.example.coursecommunity.entity.Evaluation;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    /**
     * 新增、编辑、保存评论
     *
     * @param comment
     * @return
     */
    Comment saveOrUpdateComment(Comment comment);


    /**
     * 删除评论
     *
     * @param id
     */
    void removeComment(Long id);

    /**
     * 根据id获取评论信息
     *
     * @param id
     * @return
     */
    Optional<Comment> getCommentById(Long id);

    /**
     * 根据评价ID获取评论
     *
     * @param eid
     * @param pageable
     * @return
     */
    List<Comment> searchCommentByEvaluationId(long eid, Pageable pageable);
}
