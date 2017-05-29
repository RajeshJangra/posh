package com.xebia.hr.repository;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    public List<Attempt> findByCourseAndEmployee(Course course, Employee employee);

    public List<Attempt> findByCourse(Course course);

    //@Query(value = "SELECT count(*) from attempt GROUP BY EMPLOYEE_ID HAVING count(*) >= 3 AND EMPLOYEE_ID = :employeeId", nativeQuery = true)
    public List<Attempt> findByEmployeeIdAndResult(long employeeId, String result);

    public List<Attempt> findByEmployeeId(Long employeeId);
}
