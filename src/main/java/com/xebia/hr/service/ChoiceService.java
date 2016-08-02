package com.xebia.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.entity.Choice;
import com.xebia.hr.repository.ChoiceRepository;


/**
 * @author gauravagrawal
 */
@Service
public class ChoiceService {
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	public Choice save(Choice choice){
		return choiceRepository.save(choice);
	}
    
}
