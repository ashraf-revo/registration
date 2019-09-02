package org.revo.registration.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.servlet.ServletRegistration;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:32 PM.
 */

@Configuration
@Profile("h2_console")
public class H2ConsoleConfig {
    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> {
            ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new WebServlet());
            h2ConsoleServlet.addMapping("/h2-console/*");
            h2ConsoleServlet.setInitParameter("-properties", "src/main/resources");
            h2ConsoleServlet.setLoadOnStartup(1);
        };
    }
}
