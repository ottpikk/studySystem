package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.repositories.CourseRepository;
import com.sda.studysystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementaation of CourseService
 *
 * @author Ott Pikk
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void createCourse(Course course) {
        course.setActive(true);
        courseRepository.save(course);
    }

    @Override
    public Course findCourseById(Long id) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isEmpty()) {
            throw new CourseNotFoundException(id);
        }
        return optionalCourse.get();
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void updateCourse(Course course) throws CourseNotFoundException {
        if (findCourseById(course.getId()) != null){
            courseRepository.saveAndFlush(course);
        }
    }

    @Override
    public void deleteCourseById(Long id) throws CourseNotFoundException {
        Course course = findCourseById(id);
        course.setActive(false);
        courseRepository.saveAndFlush(course);
    }

    @Override
    public void restoreCourseById(Long id) throws CourseNotFoundException {
        Course course = findCourseById(id);
        course.setActive(true);
        courseRepository.saveAndFlush(course);
    }
}
