package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository to handle teacher related DB operations
 *
 * @author Ott Pikk
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
