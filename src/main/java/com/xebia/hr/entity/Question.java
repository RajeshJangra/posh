package com.xebia.hr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

    @Id
    @Column(columnDefinition = "Integer(10)", name = "ID")
    private long id;

    @Column(nullable = false, columnDefinition = "Varchar(30)", name = "NAME")
    private String name;

    @Column(nullable = false, columnDefinition = "Varchar(1000)", name = "DESCRIPTION")
    private String description;

    @Column(nullable = false, columnDefinition = "Varchar(1)", name = "ANSWER")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(final Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", answer='" + answer + '\'' + ", course=" + course + '}';
    }
}