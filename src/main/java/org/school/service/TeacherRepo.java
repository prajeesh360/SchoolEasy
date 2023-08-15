package org.school.service;

import java.util.List;
import java.util.Optional;
import org.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByName(String name);

    Iterable<Teacher> findAllByName(String name);

    List<Teacher> findByNameLike(String pattern);

    List<Teacher> findAllByTeacherQualifications_Degree(String degree);
}
