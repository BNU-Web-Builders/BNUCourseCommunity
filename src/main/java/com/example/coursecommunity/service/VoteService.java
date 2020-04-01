package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Vote;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface VoteService {

    /**
     * 根据id获取Vote
     *
     * @param id
     * @return
     */
    Optional<Vote> getVoteById(Long id);

    /**
     * 删除Vote
     *
     * @param id
     */
    void removeVote(Long id);
}
