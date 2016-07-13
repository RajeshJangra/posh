package com.xebia.hr.repository;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anirudh on 20/07/15.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findByCourses(Course course);

}
