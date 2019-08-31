package org.revo.registration.delegates;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.revo.registration.domain.CourseInfo;
import org.revo.registration.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:30 PM.
 */

@Component
@Slf4j
public class FetchCourseInfo implements JavaDelegate {
    private CourseInfoService courseInfoService;

    @Autowired
    public FetchCourseInfo setCourseService(CourseInfoService courseInfoService) {
        this.courseInfoService = courseInfoService;
        return this;
    }

    @Override
    public void execute(DelegateExecution execution) {
        CourseInfo courseInfo = this.courseInfoService.findByCourse_Id(((Long) execution.getVariable("courseId")));
        execution.setVariable("courseInfo", courseInfo);
        log.info("fetch Course info " + courseInfo);
    }
}

