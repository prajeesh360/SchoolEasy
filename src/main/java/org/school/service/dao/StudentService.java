package org.school.service.dao;

import java.util.List;
import org.school.model.ResponseObject;
import org.school.model.Student;

public interface StudentService {
    ResponseObject addStudent(Student student);

    Student getStudent(long id);

    Student getStudent(String name);

    ResponseObject updateStudent(Student student);

    List<Student> getAllCourse();
}
