package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.Course;

import java.util.List;

/**
 * To handle course related services
 *
 * @author Ott Pikk
 */
public interface CourseService {

    /**
     * To create a new course
     * @param course Course
     */
    void createCourse(Course course);

    /**
     * To find a course by its ID
     * @param id id of the course
     * @return Course
     */
    Course findCourseById(Long id) throws CourseNotFoundException;

    /**
     * To find all courses
     * @return List of Courses
     */
    List<Course> findAllCourses();

    /**
     * To update an existing course
     * @param course Course
     */
    void updateCourse(Course course) throws CourseNotFoundException;

    /**
     * To delete course by its ID
     * @param id id of the course
     */
    void deleteCourseById(Long id) throws CourseNotFoundException;

    /**
     * To restore a course by its ID
     * @param id id of the course
     */
    void restoreCourseById(Long id) throws CourseNotFoundException;

}
