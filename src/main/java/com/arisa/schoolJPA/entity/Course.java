package com.arisa.schoolJPA.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;

    @Column(name = "coursename", nullable = false)
    private String courseName;

    @Column(name = "coursedesc")
    private String courseDesc;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    private Teacher courseTeacher;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> studentRoster;
}
