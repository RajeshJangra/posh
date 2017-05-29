package com.xebia.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	public List<Attempt> findByCourse(Course course);

    @Query(value = "SELECT count(*) from attempt GROUP BY EMPLOYEE_ID HAVING count(*) >= 3 AND EMPLOYEE_ID = :employeeId", nativeQuery = true)
    public int countDistinctAttemptsByEmployeeId(@Param("employeeId") Long employeeId);

	public List<Attempt> findByEmployeeId(Long employeeId);
}
