package com.sda.studysystem.components;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Component to initialize data on app startup
 *
 * @author Ott Pikk
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;

    @PostConstruct
    public void init() {
        initSchool();
    }

    // PRIVATE METHODS //
    private void initSchool() {
        System.out.println("Starting initializing school..");
        School school = new School();
        school.setName("Viljandi Vocational Center");
        school.setCity("Viljandi");
        school.setPhone("+372 458 7894");
        try{

            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Cannot pre-initialize school:" + school.getName());
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }
}
