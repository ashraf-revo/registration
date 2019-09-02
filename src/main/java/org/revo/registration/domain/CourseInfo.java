package org.revo.registration.domain;

import lombok.*;

import javax.persistence.*;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:35 PM.
 */


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"course"})
public class CourseInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private String meta;
    private int capacity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Course course;
}
