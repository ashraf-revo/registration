package org.revo.registration.service;

import org.revo.registration.domain.Student;

import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:02 PM.
 */

public interface StudentService {
    Student save(Student student);

    List<Student> findAll();

    long count();
}
