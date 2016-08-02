package com.xebia.hr.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.xebia.hr.constants.AppConstants;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "ATTEMPT")
public class Attempt extends AbstractPersistable<Long> implements Serializable, Comparable<Attempt> {

    @Column(columnDefinition = "Integer(3)", name = "SCORE")
    private Integer score;

    @Column(columnDefinition = "Integer(3)", name = "MAX_SCORE")
    private Integer maxScore;
    
    @Column(name = "SCORE_PERCENT")
    private Double scoreInPercent;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(final Integer maxScore) {
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
	
	public Double getScoreInPercent() {
		return scoreInPercent;
	}

	public void setScoreInPercent(Double scoreInPercent) {
		this.scoreInPercent = scoreInPercent;
	}

	@Override
	public int compareTo(Attempt o) {
		return this.startTime.compareTo(o.startTime);
	}
}