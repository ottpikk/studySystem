package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("schools", schoolService.findAllSchools());
        return "school/list-school";
    }
    @GetMapping("/create")
    public String showCreateSchoolPage(@ModelAttribute("schools") School school,
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
}
