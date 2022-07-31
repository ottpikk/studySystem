package com.sda.studysystem.repositories;

import com.sda.studysystem.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository to handle school related DB operations
 *
 * @author Ott Pikk
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, UUID> {
    Optional<School> findByName(String name);

}
