package org.revo.registration.service.impl;

import org.revo.registration.domain.CourseInfo;
import org.revo.registration.repository.CourseInfoRepository;
import org.revo.registration.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:46 PM.
 */

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    private CourseInfoRepository courseInfoRepository;

    @Transactional
    @Override
    public CourseInfo save(CourseInfo courseInfo) {
        return courseInfoRepository.save(courseInfo);
    }

    @Override
    public CourseInfo findByCourse_Id(Integer id) {
        return courseInfoRepository.findByCourse_Id(id);
    }

    @Transactional
    @Override
    public int decCapacity(Integer id) {
        return courseInfoRepository.decCapacity(id);
    }

    @Override
    public List<CourseInfo> findAll() {
        return StreamSupport.stream(courseInfoRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
