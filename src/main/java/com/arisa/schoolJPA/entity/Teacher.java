package com.arisa.schoolJPA.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private Integer id;

    @Column(name = "tfname")
    private String fName;

    @Column(name = "tlname")
    private String lName;

    @Column(name = "dept")
    private String dept;

    @OneToMany(mappedBy = "courseTeacher")
    private Set<Course> teacherClasses;
}
