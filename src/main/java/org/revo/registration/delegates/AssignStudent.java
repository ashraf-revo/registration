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
        Course course = Course.builder().id(((Long) execution.getVariable("courseId"))).build();
        Student student = Student.builder().id(((Long) execution.getVariable("studentId"))).build();
        scService.save(new SC(null, student, course));
    }
}
