package com.sda.studysystem.exceptions;

/**
 * Exception for the teacher not found by ID
 *
 * @author Ott Pikk
 */
public class TeacherNotFoundException extends Exception{
    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher not found for id: %d", id));
    }
}
