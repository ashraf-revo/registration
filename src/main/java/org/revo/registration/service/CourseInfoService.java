package org.revo.registration.service;

import org.revo.registration.domain.CourseInfo;

import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:46 PM.
 */

public interface CourseInfoService {
    CourseInfo save(CourseInfo courseInfo);

    CourseInfo findByCourse_Id(Integer id);

    int decCapacity(Integer id);

    List<CourseInfo> findAll();
}
