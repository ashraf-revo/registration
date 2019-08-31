package org.revo.registration.service.impl;

import org.revo.registration.domain.Course;
import org.revo.registration.repository.CourseRepository;
import org.revo.registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:53 PM.
 */

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return StreamSupport.stream(courseRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return courseRepository.count();
    }
}
