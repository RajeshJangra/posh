package com.xebia.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Choice;

/**
 * @author gauravagrawal
 */
@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

}
