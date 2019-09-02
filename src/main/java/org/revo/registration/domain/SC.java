package org.revo.registration.domain;

import lombok.*;

import javax.persistence.*;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:40 PM.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SC {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JoinColumn
    private Course course;
}
