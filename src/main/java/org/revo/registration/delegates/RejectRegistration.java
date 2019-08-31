package org.revo.registration.delegates;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 6:32 PM.
 */

@Component
@Slf4j
public class RejectRegistration implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.warn("RejectRegistration for studentId " + execution.getVariable("studentId"));
    }
}
