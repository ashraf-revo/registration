package org.revo.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revo.registration.domain.Course;
import org.revo.registration.domain.CourseInfo;
import org.revo.registration.domain.Student;
import org.revo.registration.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:32 PM.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SCService scService;
    @Autowired
    private RegistrationService registrationService;

    @PostConstruct
    public void init() {

        if (courseService.count() == 0) {
            Course course1 = courseService.save(new Course(null, "java", Collections.emptyList()));
            courseInfoService.save(new CourseInfo(null, "java basic", 50, course1));
            Course course2 = courseService.save(new Course(null, "mongo", Collections.emptyList()));
            courseInfoService.save(new CourseInfo(null, "mongo advanced", 0, course2));
        }
        if (studentService.count() == 0) {
            studentService.save(new Student(null, UUID.randomUUID().toString(), 1000, Collections.emptyList()));
            studentService.save(new Student(null, UUID.randomUUID().toString(), 2000, Collections.emptyList()));
        }
    }

    /*
     *
     * Test when capacity greater than 0
     * */
    @Test
    public void capacityGreaterThan0() {

        Student student = studentService.findAll().stream().filter(it -> it.getBalance() >= 2000).findAny().get();
        courseInfoService.findAll().stream().filter(it -> it.getCapacity() > 0).findAny()
                .ifPresent(it -> {
                    Map<String, Object> variables = new HashMap<>();
                    variables.put("courseId", it.getCourse().getId());
                    variables.put("studentId", student.getId());
                    variables.put("balance", student.getBalance());
                    registrationService.handle(variables);
                    assertThat(it.getCapacity() - 1, equalTo(courseInfoService.findByCourse_Id(it.getCourse().getId()).getCapacity()));
                    assertThat(scService.findAll(), hasItem(allOf(hasProperty("student", hasProperty("id", is(student.getId()))), hasProperty("course", hasProperty("id", is(it.getCourse().getId()))))));

                });
    }

    /*
     *
     * Test when capacity equal to 0
     * */
    @Test
    public void capacityEqualTo0() {
        Student student = studentService.findAll().stream().filter(it -> it.getBalance() >= 2000).findAny().get();
        courseInfoService.findAll().stream().filter(it -> it.getCapacity() == 0).findAny()
                .ifPresent(it -> {
                    Map<String, Object> variables = new HashMap<>();
                    variables.put("courseId", it.getCourse().getId());
                    variables.put("studentId", student.getId());
                    variables.put("balance", student.getBalance());
                    registrationService.handle(variables);
                    assertThat(it.getCapacity(), equalTo(courseInfoService.findByCourse_Id(it.getCourse().getId()).getCapacity()));
                });
    }

    /*
     *
     * Test when capacity greater than Equal 2000
     * */
    @Test
    public void balanceGreaterThanEqual2000() {
        Student student = studentService.findAll().stream().filter(it -> it.getBalance() >= 2000).findAny().get();
        courseInfoService.findAll().stream().filter(it -> it.getCapacity() > 0).findAny()
                .ifPresent(it -> {
                    Map<String, Object> variables = new HashMap<>();
                    variables.put("courseId", it.getCourse().getId());
                    variables.put("studentId", student.getId());
                    variables.put("balance", student.getBalance());
                    registrationService.handle(variables);
                    assertThat(it.getCapacity() - 1, equalTo(courseInfoService.findByCourse_Id(it.getCourse().getId()).getCapacity()));
                    assertThat(scService.findAll(), hasItem(allOf(hasProperty("student", hasProperty("id", is(student.getId()))), hasProperty("course", hasProperty("id", is(it.getCourse().getId()))))));
                });
    }

    /*
     *
     * Test when capacity Less than  2000
     * */
    @Test
    public void balanceLessThan2000() {
        Student student = studentService.findAll().stream().filter(it -> it.getBalance() < 2000).findAny().get();
        courseInfoService.findAll().stream().filter(it -> it.getCapacity() > 0).findAny()
                .ifPresent(it -> {
                    Map<String, Object> variables = new HashMap<>();
                    variables.put("courseId", it.getCourse().getId());
                    variables.put("studentId", student.getId());
                    variables.put("balance", student.getBalance());
                    registrationService.handle(variables);
                    assertThat(it.getCapacity(), equalTo(courseInfoService.findByCourse_Id(it.getCourse().getId()).getCapacity()));
                });
    }

    @Test
    public void handle() {
        Student student = studentService.findAll().stream().filter(it -> it.getBalance() >= 2000).findAny().get();
        CourseInfo courseInfo = courseInfoService.findAll().stream().filter(it -> it.getCapacity() > 0).findAny().get();
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("courseId", courseInfo.getCourse().getId());
        map.put("balance", student.getBalance());
        this.restTemplate.postForObject("/handle", map, Void.class);
    }

}
