package com.xebia.hr.service;

import com.xebia.hr.entity.Attempt;
import com.xebia.hr.repository.AttemptArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptArchiveService {

    @Autowired
    private AttemptArchiveRepository attemptArchiveRepository;

    public void saveAttemptArchives(List<Attempt> attempts) {
        attempts.stream().forEach(attempt -> attemptArchiveRepository.save(attempt));
    }
}
