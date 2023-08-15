package org.school.service.dao;

import java.util.List;
import org.school.model.ResponseObject;
import org.school.model.Teacher;

public interface TeacherService {
    ResponseObject addTeacher(Teacher teacher);

    Teacher getTeacher(long teacherId);

    Teacher getTeacher(String name);

    ResponseObject updateTeacher(Teacher teacher, Long id);

    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeachersWithDegree(String degree);
}
