package com.sda.studysystem.exceptions;

/**
 * Exception for the school not found by id
 *
 * @author Ott Pikk
 */
public class SchoolNotFoundException extends Exception {
    public SchoolNotFoundException(Long id){
        super(String.format("School not found for id: %d ", id));
    }

    public SchoolNotFoundException(String name){

        super(String.format("School not found for id: %s ", name));
    }
}
