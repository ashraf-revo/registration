package org.revo.registration.repository;

import org.revo.registration.domain.CourseInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:40 PM.
 */

public interface CourseInfoRepository extends CrudRepository<CourseInfo, Integer> {
    CourseInfo findByCourse_Id(Integer id);

    @Modifying
    @Query("update CourseInfo as ci set ci.capacity=ci.capacity-1 where ci.course.id=?1")
    int decCapacity(Integer id);
}
