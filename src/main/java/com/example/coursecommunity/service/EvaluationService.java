package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Course;
import com.example.coursecommunity.entity.Evaluation;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {
    /**
     * 新增、编辑、保存评价
     * @param evaluation
     * @return
     */
    Evaluation saveOrUpdateEvaluation(Evaluation evaluation);


    /**
     * 删除评价
     * @param id
     */
    void removeEvaluation(Long id);

    /**
     * 根据id获取评价信息
     * @param id
     * @return
     */
    Optional<Evaluation> getEvaluationById(Long id);

    /**
     * 根据课程ID获取评价
     * @param cid
     * @param pageable
     * @return
     */
    List<Evaluation> searchEvaluationByCourseId(long cid, Pageable pageable);

    /**
     * 点赞
     * @param evaluationId
     * @return
     */
    Evaluation createVote(Long evaluationId);

    /**
     * 取消点赞
     * @param evaluationId
     * @param voteId
     */
    void removeVote(Long evaluationId,Long voteId);
}
