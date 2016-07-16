package com.xebia.hr.repository;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anirudh on 20/07/15.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByEmployees(Employee employee);
	
}
