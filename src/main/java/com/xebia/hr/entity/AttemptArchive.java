package com.xebia.hr.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Created by jasleen on 12/05/17.
 */
@Entity @IdClass(AttemptArchiveId.class)
@Table(name = "ATTEMPT_ARCHIVE")
public class AttemptArchive extends AbstractPersistable<Long> implements Serializable, Comparable<AttemptArchive> {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BigInteger(20)", name = "ARCHIVE_ID")
    private Long id;

    @Id
    @Column(columnDefinition = "BigInteger(20)", name = "ATTEMPT_ID")
    private Long attemptId;

    @Column(columnDefinition = "Integer(3)", name = "SCORE")
    private int score;

    @Column(columnDefinition = "Integer(3)", name = "MAX_SCORE")
    private int maxScore;

    @Column(name = "SCORE_PERCENT")
    private double scoreInPercent;

    @Column(columnDefinition = "Varchar(20)", name = "RESULT")
    private String result;

    @Column(name = "START_TIME", nullable = false)
    private Timestamp startTime;

    @Column(name = "FINISH_TIME")
    private Timestamp finishTime;

    @Column(name = "POLICY_AGREED", columnDefinition = "tinyint(1) default 0")
    private boolean policyAgreed;

    public Long getArchiveId() {
        return id;
    }

    public void setArchiveId(Long archiveId) {
        this.id = archiveId;
    }

    public long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(final int maxScore) {
        this.maxScore = maxScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(final String result) {
        this.result = result;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public double getScoreInPercent() {
        return scoreInPercent;
    }

    public void setScoreInPercent(double scoreInPercent) {
        this.scoreInPercent = scoreInPercent;
    }

    public boolean isPolicyAgreed() {
        return policyAgreed;
    }

    public void setPolicyAgreed(boolean policyAgreed) {
        this.policyAgreed = policyAgreed;
    }

    @Override
    public int compareTo(AttemptArchive o) {
        return this.startTime.compareTo(o.startTime);
    }

    public AttemptArchive() {
    }

    public AttemptArchive(Attempt attempt) {
        this.attemptId = attempt.getId();
        this.score = attempt.getScore();
        this.maxScore = attempt.getMaxScore();
        this.scoreInPercent = attempt.getScoreInPercent();
        this.result = attempt.getResult();
        this.startTime = attempt.getStartTime();
        this.finishTime = attempt.getFinishTime();
        this.policyAgreed = attempt.isPolicyAgreed();
    }
}