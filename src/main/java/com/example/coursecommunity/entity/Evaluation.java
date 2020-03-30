package com.example.coursecommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Evaluation {//点赞和踩尚未实现
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long cId;

    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp createTime;//评价创建时间,自动入库

    @NotEmpty(message = "评价文字内容不能为空")
    @Size(min = 2,max = 500)
    @Column(nullable = false)
    private String content;

    private  boolean isTaken;//	是否上完这门课

    @Min(0)
    @Max(5)
    private int ranking=0;//	综合评分	5分制
    @Min(0)
    @Max(5)
    private int homework=0;//	作业多少	5分制
    @Min(0)
    @Max(5)
    private int difficulty=0;//	课程难度	5分制
    @Min(0)
    @Max(5)
    private int gain=0;//	收获大小	5分制
    @Min(0)
    @Max(5)
    private int noviceFriendly=0;//	小白友好度（是否需要基础）	5分制
    @Min(0)
    @Max(5)
    private int markRange=0;//	期末给分情况	5分制,(不合格，60+，70+，80+，90+）

    @Column(length = 50)
    private String finalTestWay="";//	期末考核具体形式	varchar

    @Column(name = "voteSize")
    private Integer voteSize=0;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "evaluation_vote",
            joinColumns = @JoinColumn(name = "evaluation_id",referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name = "vote_id",referencedColumnName = "id"))
    private List<Vote> votes;


    public Evaluation() {
    }

    public Evaluation(@NotEmpty(message = "评价文字内容不能为空") @Size(min = 2, max = 500) String content, boolean isTaken, @Min(0) @Max(5) int ranking, @Min(0) @Max(5) int homework, @Min(0) @Max(5) int difficulty, @Min(0) @Max(5) int gain, @Min(0) @Max(5) int noviceFriendly, @Min(0) @Max(5) int markRange, String finalTestWay) {
        this.content = content;
        this.isTaken = isTaken;
        this.ranking = ranking;
        this.homework = homework;
        this.difficulty = difficulty;
        this.gain = gain;
        this.noviceFriendly = noviceFriendly;
        this.markRange = markRange;
        this.finalTestWay = finalTestWay;
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

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
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

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getHomework() {
        return homework;
    }

    public void setHomework(int homework) {
        this.homework = homework;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getNoviceFriendly() {
        return noviceFriendly;
    }

    public void setNoviceFriendly(int noviceFriendly) {
        this.noviceFriendly = noviceFriendly;
    }

    public int getMarkRange() {
        return markRange;
    }

    public void setMarkRange(int markRange) {
        this.markRange = markRange;
    }

    public String getFinalTestWay() {
        return finalTestWay;
    }

    public void setFinalTestWay(String finalTestWay) {
        this.finalTestWay = finalTestWay;
    }

    public Integer getVoteSize() {
        return voteSize;
    }

    public void setVoteSize(Integer voteSize) {
        this.voteSize = voteSize;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
        this.voteSize=this.votes.size();
    }

    /**
     * 点赞
     * @param vote
     * @return
     */
    public boolean addVote(Vote vote){
        boolean isExist=false;
        for (int index=0;index<this.votes.size();index++){
            if (this.votes.get(index).getUser().getId()==vote.getUser().getId()){
                isExist=true;
                break;
            }
        }
        if (!isExist){
            this.votes.add(vote);
            this.voteSize=this.votes.size();
        }
        return isExist;
    }

    public void removeVote(Long voteId){
        for (int index=0;index<this.votes.size();index++){
            if(this.votes.get(index).getId()==voteId){
                this.votes.remove(index);
                break;
            }
        }
        this.voteSize=this.votes.size();
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", userId=" + userId +
                ", cId=" + cId +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", isTaken=" + isTaken +
                ", ranking=" + ranking +
                ", homework=" + homework +
                ", difficulty=" + difficulty +
                ", gain=" + gain +
                ", noviceFriendly=" + noviceFriendly +
                ", markRange=" + markRange +
                ", finalTestWay='" + finalTestWay + '\'' +
                ", voteSize=" + voteSize +
                ", votes=" + votes +
                '}';
    }
}
