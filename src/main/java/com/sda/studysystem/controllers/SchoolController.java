package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle school related request
 *
 * @author Ott Pikk
 */
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @GetMapping
    public String showSchoolListPage(Model model, @ModelAttribute("message")String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("school", schoolService.findAllSchools());
        return "school/list-school";
    }

    @GetMapping("/{id}")
    public String showSchoolViewPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes ) {
        try{
            model.addAttribute("school", schoolService.findSchoolById(id));
            return "school/view-school";
        } catch (SchoolNotFoundException e) {
            return handleSchoolNotFoundException(id, redirectAttributes);
        }

    }
    @GetMapping("/create")
    public String showCreateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message")String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "school/create-school";
    }
    @PostMapping
    public String createSchool(School school, RedirectAttributes redirectAttributes) {
        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            redirectAttributes.addAttribute("message",
                    String.format("School(%s) already exists!", searchSchool.getName()));
            redirectAttributes.addAttribute("messageType", "error");
            return "redirect:/school/create";
        } catch(SchoolNotFoundException e) {
            redirectAttributes.addAttribute("message",
                    String.format("School(%s) created successfully", school.getName()));
            redirectAttributes.addAttribute("messageType", "success");
            schoolService.createSchool(school);
            return "redirect:/school";
        }
    }

    /*
    GET list-       school "/school"
    POST create -   school "/school"
    POST update -   school "/school/{id}"
     */
    @GetMapping("/update/{id}")
    public String showUpdateSchoolPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes,
                                       @RequestParam(value="school", required = false) School school ) {
        if(school == null) {
            try {
                model.addAttribute("school", schoolService.findSchoolById(id));
            } catch (SchoolNotFoundException e) {
                return handleSchoolNotFoundException(id, redirectAttributes);
            }
        }
        return "school/update-school";
    }
    @PostMapping("/update")
    public String updateSchool(School school, RedirectAttributes redirectAttributes) {
        try {
            schoolService.updateSchool(school);
            redirectAttributes.addAttribute("message",
                    String.format("School(id=%d) updated successfully", school.getId()));
            redirectAttributes.addAttribute("messageType", "success");
            return "redirect:/school";
        } catch (SchoolNotFoundException e) {
            return handleSchoolNotFoundException(school.getId(), redirectAttributes);
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable Long id, RedirectAttributes redirectAttributes) {
       try{
           schoolService.deleteSchoolById(id);
           redirectAttributes.addAttribute("message",
                   String.format("School(id=%d) deleted successfully", id));
           redirectAttributes.addAttribute("messageType", "success");
           return "redirect:/school";
       } catch (SchoolNotFoundException e) {
           return handleSchoolNotFoundException(id, redirectAttributes);
       }
    }
    @GetMapping("/restore/{id}")
    public String restoreSchool(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try{
            schoolService.restoreSchoolById(id);
            redirectAttributes.addAttribute("message",
                    String.format("School(id=%d) restored successfully", id));
            redirectAttributes.addAttribute("messageType", "success");
            return "redirect:/school";
        } catch (SchoolNotFoundException e) {
            return handleSchoolNotFoundException(id, redirectAttributes);
        }
    }

    //PRIVATE METHODS //
    private String handleSchoolNotFoundException(Long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message",
                String.format("School(id=%d) not found", id));
        redirectAttributes.addAttribute("messageType", "error");
        return "redirect:/school";
    }
}
