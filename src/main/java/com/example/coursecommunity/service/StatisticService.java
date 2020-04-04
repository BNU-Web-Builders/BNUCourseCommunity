package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Evaluation;

import java.util.List;
import java.util.Map;

public interface StatisticService {
    /**
     * 各种rank统计
     * @param evaluationList
     * @return
     */
    List<Integer> rankCounting(List<Evaluation> evaluationList);

    /**
     * 词频统计
     * @param contentList
     * @return
     */
    List<Map.Entry<String, Integer>> wordFrequency(List<String> contentList);
}
