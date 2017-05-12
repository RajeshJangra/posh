package com.xebia.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.AttemptArchive;

@Repository
public interface AttemptArchiveRepository extends JpaRepository<AttemptArchive, Long> {

	public List<AttemptArchive> save(List<Attempt> attempts);
	
	public AttemptArchive save(Attempt attempt, long tryId);
}
