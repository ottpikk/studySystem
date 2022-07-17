package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle course related DB operations
 *
 * @author Ott Pikk
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
