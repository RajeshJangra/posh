package com.xebia.hr.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "EMPLOYEE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee implements Serializable {

    @Id
    @Column(columnDefinition = "Varchar(10)", name = "ID")
    private String id;

    @Column(nullable = false, columnDefinition = "Varchar(100)", name = "NAME")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOJ")
    private Date dateOfJoining;

    @Column(nullable = false, columnDefinition = "Varchar(30)", name = "DESIGNATION")
    private String designation;

    @Column(nullable = false, columnDefinition = "Varchar(50)", name = "EMAIL")
    private String email;

    @Column(nullable = false, columnDefinition = "Varchar(30)", name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(nullable = false, name = "GENDER", columnDefinition = "Varchar(6)")
    private String gender;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_COURSE", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "COURSE_ID", nullable = false, updatable = false)})
    private Set<Course> courses = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(final Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(final String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(final Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", dateOfJoining=" + dateOfJoining + ", designation='" + designation + '\'' + ", email='" + email + '\'' + ", contactNumber='" + contactNumber + '\'' + ", gender='" + gender + '\'' + ", courses=" + courses + '}';
    }
}