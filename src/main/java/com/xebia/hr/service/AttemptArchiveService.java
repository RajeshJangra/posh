package com.xebia.hr.service;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.AttemptArchive;
import com.xebia.hr.repository.AttemptArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptArchiveService {

    @Autowired
    private AttemptArchiveRepository attemptArchiveRepository;

    public AttemptArchive createAttemptBackup(Attempt attempt) {
        return attemptArchiveRepository.save(new AttemptArchive(attempt));
    }



}
