package com.xebia.hr.entity;

import com.xebia.hr.constants.AppConstants;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "ATTEMPT")
public class Attempt extends AbstractPersistable<Long> implements Serializable, Comparable<Attempt> {

    @Column(columnDefinition = "Integer(3)", name = "SCORE")
    private int score;

    @Column(columnDefinition = "Integer(3)", name = "MAX_SCORE")
    private int maxScore;
    
    @Column(name = "SCORE_PERCENT")
    private double scoreInPercent;

    /**
	 * Courses's result states
	 * @see AppConstants.PASSED etc
	 */
    @Column(columnDefinition = "Varchar(20)", name = "RESULT")
    private String result;
    
    @Column(name = "START_TIME", nullable=false)
    private Timestamp startTime;
    
    @Column(name = "FINISH_TIME")
    private Timestamp finishTime;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable=false)
    private Employee employee;
    
    @Column(name = "POLICY_AGREED", columnDefinition="tinyint(1) default 0")
    private boolean policyAgreed;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(final Course course) {
        this.course = course;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
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
	public int compareTo(Attempt o) {
		return this.startTime.compareTo(o.startTime);
	}
}