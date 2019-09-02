package org.revo.registration.service;

import org.revo.registration.domain.SC;

import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:10 PM.
 */

public interface SCService {
    SC save(SC sc);

    List<SC> findAll();
}
