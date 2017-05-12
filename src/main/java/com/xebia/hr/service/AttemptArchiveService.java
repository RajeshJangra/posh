package com.xebia.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.AttemptArchive;
import com.xebia.hr.repository.AttemptArchiveRepository;

@Service
public class AttemptArchiveService  {

	@Autowired
	private AttemptArchiveRepository attemptArchiveRepository;

	/*
	 * @Todo AttemptArchiveService(get try id, insert into attempt archive)
	 * @Param attempt and tryId
	 * @Return AttemptArchive entity
	 */
	public AttemptArchive save(Attempt attempt, long tryId) {
		return attemptArchiveRepository.save(attempt, tryId);
	}

}
