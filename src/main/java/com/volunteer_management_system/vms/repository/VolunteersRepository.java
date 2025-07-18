package com.volunteer_management_system.vms.repository;

import com.volunteer_management_system.vms.entity.Volunteers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface VolunteersRepository extends JpaRepository<Volunteers, Long> {
    /**
     * Custom query to search volunteers by any attribute (name, age, department, location).
     * Uses SQL LIKE and OR to match the keyword against all relevant fields.
     */
    @Query("SELECT v FROM Volunteers v WHERE " +
           "LOWER(v.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "CAST(v.age AS string) LIKE CONCAT('%', :keyword, '%') OR " +
           "LOWER(v.department) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(v.location) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Volunteers> searchVolunteers(@Param("keyword") String keyword);
}
