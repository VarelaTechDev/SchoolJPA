package com.arisa.schoolJPA.controller;

import com.arisa.schoolJPA.dao.CourseRepo;
import com.arisa.schoolJPA.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> allCourses() {
        List<Course> courses = courseRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){
        Course course = courseRepo.findById(id).orElse(null);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewCourse(@RequestBody Course course){
        courseRepo.save(course);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



}
