package org.school.service.dao.impl;

import java.util.List;
import org.school.model.ResponseObject;
import org.school.model.Student;
import org.school.service.StudentRepo;
import org.school.service.dao.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired StudentRepo studentRepo;

    @Override
    public ResponseObject addStudent(Student student) {
        ResponseObject responseObject = new ResponseObject();
        try {
            long id = studentRepo.save(student).getId();
            responseObject.setStatus(true);
            responseObject.setMessage("Course object with id " + id);
        } catch (Exception e) {
            responseObject.setStatus(false);
            responseObject.setError(e.getMessage());
            responseObject.setMessage("Error while saving course.");
        }
        return responseObject;
    }

    @Override
    public Student getStudent(long id) {
        return null;
    }

    @Override
    public Student getStudent(String name) {
        return null;
    }

    @Override
    public ResponseObject updateStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> getAllCourse() {
        return null;
    }
}
