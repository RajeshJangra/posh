package com.xebia.hr.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "CHOICE")
public class Choice implements Serializable {

    @Id
    @Column(columnDefinition = "Integer(10)", name = "ID")
    private long id;

    @Column(nullable = false, columnDefinition = "Varchar(1000)", name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @JsonIgnore
    private Question question;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Choice choice = (Choice) o;
        return id == choice.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Choice{" + "id=" + id + ", description='" + description + '\'' + ", question=" + question + '}';
    }
}