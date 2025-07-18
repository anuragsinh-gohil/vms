package com.volunteer_management_system.vms.controller;

import com.volunteer_management_system.vms.entity.Volunteers;
import com.volunteer_management_system.vms.service.VolunteersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
//@RequestMapping
public class VolunteersController {

    // Service layer dependency to handle business logic for volunteers
    private final VolunteersService volunteersService;

    // Constructor-based dependency injection for VolunteersService
    public VolunteersController(VolunteersService volunteersService) {
        this.volunteersService = volunteersService;
    }

    /**
     * Handles GET requests to the root URL ('/').
     * Fetches all volunteers or searches by keyword if 'search' parameter is present.
     * Passes the result list to the view for display.
     */
    @GetMapping("/")
    public String getVolunteer(@RequestParam(value = "search", required = false) String search, Model model) {
        // If a search term is provided, filter volunteers by any attribute
        if (search != null && !search.isEmpty()) {
            model.addAttribute("volunteer", volunteersService.searchVolunteers(search));
        } else {
            // Otherwise, show all volunteers
            model.addAttribute("volunteer", volunteersService.getAllVolunteers());
        }
        // Pass the search value back to the view for the search bar
        model.addAttribute("search", search);
        return "volunteer";
    }

    /**
     * Handles GET requests to '/add'.
     * Displays the form to add a new volunteer.
     */
    @GetMapping("/add")
    public String addVolunteerForm(Model model){
        Volunteers volunteers = new Volunteers();
        model.addAttribute("volunteer", volunteers);
        return "add_volunteer";
    }

    /**
     * Handles POST requests to the root URL ('/').
     * Saves a new volunteer to the database.
     *
     * Validation is triggered by @Valid on the Volunteers parameter.
     */
    @PostMapping("/")
    public String saveVolunteer(@Valid @ModelAttribute("volunteer") Volunteers volunteers, BindingResult result, Model model){
        if (result.hasErrors()) {
            // Validation errors: return to form and show error messages
            model.addAttribute("volunteer", volunteers);
            return "add_volunteer";
        }
        // No validation errors: save volunteer
        volunteersService.saveVolunteer(volunteers);
        return "redirect:/";
    }

    /**
     * Handles GET requests to '/edit/{id}'.
     * Displays the form to update an existing volunteer.
     */
    @GetMapping("/edit/{id}")
    public String updateVolutneerForm(@PathVariable Long id, Model model){
        model.addAttribute("volunteer", volunteersService.getVolunteerById(id));
        return "update_volunteer";
    }

    /**
     * Handles POST requests to '/{id}'.
     * Updates an existing volunteer's information in the database.
     *
     * Validation is triggered by @Valid on the Volunteers parameter.
     */
    @PostMapping("/{id}")
    public String updateVolunteer(@PathVariable Long id,
                                  @Valid @ModelAttribute("volunteer") Volunteers volunteer,
                                  BindingResult result,
                                  Model model){
        if (result.hasErrors()) {
            // Validation errors: return to form and show error messages
            model.addAttribute("volunteer", volunteer);
            return "update_volunteer";
        }
        // No validation errors: update volunteer
        Volunteers existingVolunteer = volunteersService.getVolunteerById(id);
        existingVolunteer.setId(id);
        existingVolunteer.setName(volunteer.getName());
        existingVolunteer.setAge(volunteer.getAge());
        existingVolunteer.setDepartment(volunteer.getDepartment());
        existingVolunteer.setLocation(volunteer.getLocation());

        // Save updated volunteer object
        volunteersService.updateVolunteer(existingVolunteer);
        return "redirect:/";
    }

    /**
     * Handles GET requests to '/{id}'.
     * Deletes a volunteer by their ID.
     */
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        volunteersService.deleteVolunteerById(id);
        return "redirect:/";
    }

    /**
     * Handles all uncaught exceptions in this controller.
     * Returns a simple error page with the exception message.
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
