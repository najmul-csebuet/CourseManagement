package com.onssoftware.courseapi.course;

import com.onssoftware.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/topics/{topicId}/courses")
    public String create(@PathVariable String topicId, @RequestBody Course course) {

        course.setTopic(new Topic(topicId, "", ""));
        courseRepository.save(course);

        return "Course created";
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course read(@PathVariable String courseId) {

        Course course = courseRepository.findById(courseId).get();

        return course;
    }

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> readAll(@PathVariable String topicId) {

        List<Course> courses = courseRepository.findByTopicId(topicId);

        return courses;
    }

    @GetMapping("/topics/courses")
    public List<Course> readAll() {

        List<Course> courses = new ArrayList<>();

        courseRepository.findAll().forEach(courses::add);

        return courses;
    }

    @PutMapping("/topics/{topicId}/courses/{courseId}")
    public String update(@RequestBody Course course) {

        courseRepository.save(course);

        return "Course updated";
    }

    @DeleteMapping("/topics/{topicId}/courses/{courseId}")
    public String delete(@PathVariable String courseId) {

        courseRepository.deleteById(courseId);

        return "Course deleted";
    }
}