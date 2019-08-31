package org.revo.registration.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:34 PM.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"scs"})
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
    private List<SC> scs;
}
