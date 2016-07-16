package com.xebia.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;

/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

	public List<Attempt> findByCourseAndEmployee(Course course, Employee employee);
	
}
