package com.sda.studysystem.exceptions;

/**
 * Exception for the school not found by ID
 *
 * @author Ott Pikk"
 */

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException(Long id) {
        super(String.format("Course not found for id: %d", id));
    }
}
