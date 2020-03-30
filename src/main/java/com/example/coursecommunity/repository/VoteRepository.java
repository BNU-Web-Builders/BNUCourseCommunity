package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
