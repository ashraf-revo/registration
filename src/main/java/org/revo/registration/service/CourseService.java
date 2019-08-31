package org.revo.registration.service;

import org.revo.registration.domain.Course;

import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:53 PM.
 */

public interface CourseService {
    Course save(Course course);

    List<Course> findAll();

    long count();
}
