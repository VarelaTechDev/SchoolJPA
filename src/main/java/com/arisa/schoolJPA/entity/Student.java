package com.arisa.schoolJPA.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Integer id;

    @Column(name = "fname")
    private String fName;

    @Column(name = "lname")
    private String lName;

    @ManyToMany(mappedBy = "studentRoster")
    private Set<Course> myClasses;

}
