package org.revo.registration.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
 *  Created by revo (ashraf1abdelrasool@gmail.com)  on 8/31/19, 5:36 PM.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"scs"})
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    private List<SC> scs;
}
