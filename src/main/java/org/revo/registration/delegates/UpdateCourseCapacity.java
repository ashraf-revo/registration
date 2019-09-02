package org.revo.registration.delegates;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.revo.registration.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 7:03 PM.
 */

@Component
@Slf4j
public class UpdateCourseCapacity implements JavaDelegate {
    private CourseInfoService courseInfoService;

    @Autowired
    public UpdateCourseCapacity setCourseInfoService(CourseInfoService courseInfoService) {
        this.courseInfoService = courseInfoService;
        return this;
    }

    @Override
    public void execute(DelegateExecution execution) {
        Integer courseId = (Integer) execution.getVariable("courseId");
        int num = courseInfoService.decCapacity(courseId);
        if (num == 0) log.error("no affected rows !");
        else log.info("Update course Capacity for courseId " + courseId);
    }
}
