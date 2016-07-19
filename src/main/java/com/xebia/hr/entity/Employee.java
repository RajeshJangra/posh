package com.xebia.hr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "EMPLOYEE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "EMP_ID", nullable = false, unique = true, columnDefinition = "Varchar(5)")
	private String empId;

	@Column(nullable = false, columnDefinition = "Varchar(100)", name = "NAME")
	private String name;

	@Column(nullable = false, columnDefinition = "Varchar(30)", name = "TYPE")
	private String empType;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOJ")
	private Date dateOfJoining;

	@Column(nullable = false, columnDefinition = "Varchar(30)", name = "DESIGNATION")
	private String designation;

	@Column(nullable = false, columnDefinition = "Varchar(50)", name = "EMAIL", unique = true)
	private String email;

	@Column(nullable = false, columnDefinition = "Varchar(15)", name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(nullable = false, name = "GENDER", columnDefinition = "Varchar(6)")
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB", nullable = false)
	private Date dateOfBirth;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "IS_ACTIVE", columnDefinition="tinyint(1) default 0")
	private boolean isActive;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_PASSWORD_RESET")
	private Date lastPasswordReset;
	
	@Column(name = "AUTHORITIES", columnDefinition="Varchar(60) default 'user'")
	private String authorities;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EMPLOYEE_COURSE", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "COURSE_ID", nullable = false, updatable = false)})
	private Set<Course> courses = new HashSet<Course>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getLastPasswordReset() {
		return this.lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public String getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
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