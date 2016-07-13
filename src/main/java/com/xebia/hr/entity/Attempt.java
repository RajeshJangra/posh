package com.xebia.hr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "ATTEMPT")
public class Attempt implements Serializable {

    @Id
    @Column(columnDefinition = "Integer(3)", name = "ID")
    private long id;

    @Column(nullable = false, columnDefinition = "Integer(3)", name = "SCORE")
    private String score;

    @Column(nullable = false, columnDefinition = "Integer(3)", name = "MAX_SCORE")
    private String maxScore;

    @Column(nullable = false, columnDefinition = "Varchar(6)", name = "RESULT")
    private String result;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(final String score) {
        this.score = score;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(final String maxScore) {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Attempt attempt = (Attempt) o;
        return id == attempt.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Attempt{" + "id=" + id + ", score='" + score + '\'' + ", maxScore='" + maxScore + '\'' + ", result='" + result + '\'' + ", course=" + course + '}';
    }
}