package com.xebia.hr.repository;

import com.xebia.hr.entity.AttemptArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptArchiveRepository extends JpaRepository<AttemptArchive, Long> {
}
