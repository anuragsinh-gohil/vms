package com.volunteer_management_system.vms.service.impl;

import com.volunteer_management_system.vms.entity.Volunteers;
import com.volunteer_management_system.vms.repository.VolunteersRepository;
import com.volunteer_management_system.vms.service.VolunteersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteersServiceImpl implements VolunteersService {

    // Repository dependency for database operations
    private final VolunteersRepository volunteersRepository;

    // Constructor-based dependency injection for VolunteersRepository
    public VolunteersServiceImpl(VolunteersRepository volunteersRepository) {
        this.volunteersRepository = volunteersRepository;
    }

    /**
     * Retrieves all volunteers from the database.
     */
    @Override
    public List<Volunteers> getAllVolunteers() {
        return volunteersRepository.findAll();
    }

    /**
     * Saves a new volunteer or updates an existing one in the database.
     */
    @Override
    public Volunteers saveVolunteer(Volunteers volunteers) {
        return volunteersRepository.save(volunteers);
    }

    /**
     * Retrieves a volunteer by their ID from the database.
     */
    @Override
    public Volunteers getVolunteerById(Long id) {
        return volunteersRepository.findById(id).get();
    }

    /**
     * Updates an existing volunteer's information in the database.
     */
    @Override
    public Volunteers updateVolunteer(Volunteers volunteers) {
        return volunteersRepository.save(volunteers);
    }

    /**
     * Deletes a volunteer by their ID from the database.
     */
    @Override
    public void deleteVolunteerById(Long id) {
        volunteersRepository.deleteById(id);
    }

    /**
     * Searches volunteers by any attribute (name, age, department, location).
     * Delegates to the repository's custom query for flexible search.
     */
    @Override
    public List<Volunteers> searchVolunteers(String keyword) {
        return volunteersRepository.searchVolunteers(keyword);
    }
}
