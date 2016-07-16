package com.xebia.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Question;

/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByCourse(Course course);

}
