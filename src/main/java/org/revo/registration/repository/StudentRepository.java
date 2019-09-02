package org.revo.registration.repository;

import org.revo.registration.domain.Student;
import org.springframework.data.repository.CrudRepository;
/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:40 PM.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
