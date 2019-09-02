package org.revo.registration.delegates;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.revo.registration.domain.Course;
import org.revo.registration.domain.SC;
import org.revo.registration.domain.Student;
import org.revo.registration.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:46 PM.
 */

@Component
@Slf4j
public class AssignStudent implements JavaDelegate {
    @Autowired
    private SCService scService;

    public AssignStudent setScService(SCService scService) {
        this.scService = scService;
        return this;
    }

    @Override
    public void execute(DelegateExecution execution) {
        Course course = Course.builder().id(((Integer) execution.getVariable("courseId"))).build();
        Student student = Student.builder().id(((Integer) execution.getVariable("studentId"))).build();
        if (scService.save(new SC(null, student, course)).getId() != null) {
            log.info("successfully assign student " + student.getId() + "  to course " + course.getId());
        } else {
            log.error("can't assign student " + student.getId() + "  to course " + course.getId());
        }
    }
}
