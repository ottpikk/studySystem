package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;

import java.util.List;

/**
 * To handle school related operations
 *
 * @author Ott Pikk
 */
public interface SchoolService {

    /**
     * To create new School
     * @param school School
     */
    void createSchool(School school);

    /**
     * To find a school by its ID
     * @param id id of the school
     * @return School
     */
    School findSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To find a school by its
     * @param name name of school
     * @return school
     */
    School findSchoolByName(String name) throws SchoolNotFoundException;

    /**
     * To find all schools
     * @return List of schools
     */
    List<School> findAllSchools();

    /**
     * To update an existing school
     * @param school School
     */
    void updateSchool(School school) throws SchoolNotFoundException;

    /**
     * To delete a school by its ID
     * @param id id of the school
     */
    void deleteSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To restore a school by its ID
     * @param id id of the school
     */
    void restoreSchoolById(Long id) throws SchoolNotFoundException;
}
