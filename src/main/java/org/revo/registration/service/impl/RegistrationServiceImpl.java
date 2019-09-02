package org.revo.registration.service.impl;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.revo.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 9/2/19, 10:24 AM.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public void handle(Map<String, Object> variables) {
        runtimeService.startProcessInstanceByKey("registration", variables);
        taskService.complete(taskService.createTaskQuery().singleResult().getId());
    }
}
