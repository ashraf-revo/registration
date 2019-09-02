/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 9/2/19, 10:52 AM.
 */

package org.revo.registration.rest;

import org.revo.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegistrationRest {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/handle")
    public ResponseEntity<Void> handle(@RequestBody Map<String, Object> var) {
        registrationService.handle(var);
        return ResponseEntity.noContent().build();
    }
}
