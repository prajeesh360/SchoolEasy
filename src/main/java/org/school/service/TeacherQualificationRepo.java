package org.school.service;

import java.util.List;
import org.school.model.TeacherQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherQualificationRepo extends JpaRepository<TeacherQualification, Long> {
    List<TeacherQualification> findAllByDegree(String degree);
}
