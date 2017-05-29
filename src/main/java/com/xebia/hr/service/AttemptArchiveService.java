package com.xebia.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.repository.AttemptArchiveRepository;
import com.xebia.hr.repository.AttemptRepository;

@Service
public class AttemptArchiveService {

	@Autowired
	private AttemptRepository attemptRepository;
	
	@Autowired
	private AttemptArchiveRepository attemptArchiveRepository;
	
	public List<Attempt> createAttemptBackup(Long autoGenEmpId){
		List<Attempt> attempts = attemptRepository.findByEmployeeId(autoGenEmpId);
		for(Attempt attempt:attempts){
	    	if(attempt.getResult() != "FAILED"){
	    		attemptArchiveRepository.save(attempt);
	    }
		}
		return attempts;
	}
}
