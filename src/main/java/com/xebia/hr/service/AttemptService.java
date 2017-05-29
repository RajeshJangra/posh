package com.xebia.hr.service;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;
import com.xebia.hr.repository.AttemptRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Service
public class AttemptService {

    private final static Logger log = LoggerFactory.getLogger(AttemptService.class);

    @Autowired
    private AttemptRepository attemptRepository;

    @Autowired
    private AttemptArchiveService attemptArchiveService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    public Attempt findOne(long id) throws Exception {
        Attempt attempt = attemptRepository.findOne(id);
        if (Objects.isNull(attempt)) {
            throw new NotFoundException("Invalid attempt id" + id);
        }
        return attempt;
    }

    public Attempt save(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

    public Attempt savePartially(long courseId, String empId, int maxScore) throws NotFoundException {
        Course course = courseService.findOne(courseId);
        Employee employee = employeeService.findByEmpId(empId);

        Attempt attempt = new Attempt();
        attempt.setCourse(course);
        attempt.setEmployee(employee);
        attempt.setStartTime(new Timestamp(System.currentTimeMillis()));
        attempt.setResult(AppConstants.IN_PROGRESS);
        attempt.setMaxScore(maxScore);
        attempt.setPolicyAgreed(true);
        return attemptRepository.save(attempt);
    }

    public List<Attempt> findByCourseAndEmployee(long courseId, String empId) throws NotFoundException {
        Course course = courseService.findOne(courseId);
        Employee employee = employeeService.findByEmpId(empId);
        return attemptRepository.findByCourseAndEmployee(course, employee);
    }

    public List<Attempt> findByCourse(Course course) {
        return attemptRepository.findByCourse(course);
    }

    @Transactional
    public void deleteAttempts(long autoGenEmpId) throws NotFoundException {
        final List<Attempt> attempts = attemptRepository.findByEmployeeIdAndResult(autoGenEmpId, "FAILED");
        if (attempts.size() >= 3) {
            attempts.stream().forEach(attempt -> {
                attemptArchiveService.saveAttemptArchives(attempts);
                attemptRepository.delete(attempt);
            });
        } else {
            final String msg = "The employee still has attempts left";
            log.error(msg);
            throw new NotFoundException(msg);
        }
    }
}
