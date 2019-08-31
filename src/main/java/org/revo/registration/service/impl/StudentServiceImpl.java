package org.revo.registration.service.impl;

import org.revo.registration.domain.Student;
import org.revo.registration.repository.StudentRepository;
import org.revo.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:02 PM.
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return studentRepository.count();
    }
}
