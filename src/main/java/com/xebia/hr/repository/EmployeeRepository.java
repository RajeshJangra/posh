package com.xebia.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;

/**
 * Created by anirudh on 20/07/15.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByCourses(Course course);
    
    Employee findByEmpId(String empId);

}
