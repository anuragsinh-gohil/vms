package com.volunteer_management_system.vms.service;
import com.volunteer_management_system.vms.entity.Volunteers;
import java.util.List;

public interface VolunteersService {
    /**
     * Retrieves a list of all volunteers.
     */
    List<Volunteers> getAllVolunteers();

    /**
     * Saves a new volunteer or updates an existing one.
     */
    Volunteers saveVolunteer(Volunteers volunteers);

    /**
     * Retrieves a volunteer by their ID.
     */
    Volunteers getVolunteerById(Long id);

    /**
     * Updates an existing volunteer's information.
     */
    Volunteers updateVolunteer(Volunteers volunteers);

    /**
     * Deletes a volunteer by their ID.
     */
    void deleteVolunteerById(Long id);

    /**
     * Searches volunteers by any attribute (name, age, department, location).
     * Used for flexible search functionality in the UI.
     */
    List<Volunteers> searchVolunteers(String keyword);
}
