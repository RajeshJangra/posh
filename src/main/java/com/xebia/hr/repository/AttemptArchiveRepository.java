package com.xebia.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.AttemptArchive;

@Repository
public interface AttemptArchiveRepository extends JpaRepository<AttemptArchive, Long> {

	public AttemptArchive save(Attempt attempt);
}
