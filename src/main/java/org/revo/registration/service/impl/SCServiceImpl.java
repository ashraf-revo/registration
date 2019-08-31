package org.revo.registration.service.impl;

import org.revo.registration.domain.SC;
import org.revo.registration.repository.SCRepository;
import org.revo.registration.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:10 PM.
 */

@Service
public class SCServiceImpl implements SCService {
    @Autowired
    private SCRepository scRepository;

    @Override
    public void save(SC sc) {
        scRepository.save(sc);
    }

    @Override
    public List<SC> findAll() {
        return StreamSupport.stream(scRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
