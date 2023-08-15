package org.school.service.dao.impl;

import java.util.List;
import java.util.Optional;
import org.school.model.ResponseObject;
import org.school.model.Teacher;
import org.school.service.TeacherQualificationRepo;
import org.school.service.TeacherRepo;
import org.school.service.dao.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepo teacherRepo;
    private TeacherQualificationRepo teacherQualificationRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        super();
        this.teacherRepo = teacherRepo;
    }

    @Override
    public ResponseObject addTeacher(Teacher teacher) {
        ResponseObject responseObject = new ResponseObject();
        try {
            long id = teacherRepo.save(teacher).getId();
            responseObject.setStatus(true);
            responseObject.setMessage("Teacher object with id " + id);
        } catch (Exception e) {
            responseObject.setStatus(false);
            responseObject.setError(e.getMessage());
            responseObject.setMessage("Error while saving teacher.");
        }
        return responseObject;
    }

    @Override
    public Teacher getTeacher(long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow();
    }

    @Override
    public Teacher getTeacher(String name) {
        return teacherRepo.findByName(name).orElseThrow();
    }

    @Override
    public ResponseObject updateTeacher(Teacher teacher, Long id) {
        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        System.out.println(teacher.toString());
        ResponseObject responseObject = new ResponseObject();
        if (optionalTeacher.isPresent()) {
            Teacher existingTeacher = optionalTeacher.get();
            System.out.println(existingTeacher.toString());
            if (teacher.getName() != null) existingTeacher.setName(teacher.getName());
            if (teacher.getEmail() != null) existingTeacher.setEmail(teacher.getEmail());
            if (teacher.getMobile() != null) existingTeacher.setMobile(teacher.getMobile());
            if (teacher.getAddress() != null) existingTeacher.setAddress(teacher.getAddress());
            if (teacher.getTeacherQualifications() != null
                    && !teacher.getTeacherQualifications().isEmpty()) {
                teacher.getTeacherQualifications()
                        .forEach(
                                tech -> {
                                    if (!existingTeacher
                                            .getTeacherQualifications()
                                            .contains(tech)) {
                                        existingTeacher.getTeacherQualifications().add(tech);
                                    } else {
                                        System.out.println("Recorded exists");
                                    }
                                });
            }
            teacherRepo.save(existingTeacher);
            responseObject.setStatus(true);
            responseObject.setMessage("Employee record added");
        } else {
            responseObject.setStatus(false);
            responseObject.setError("Teacher Not found by id " + id);
            responseObject.setMessage("");
        }
        return responseObject;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public List<Teacher> getAllTeachersWithDegree(String degree) {
        return teacherRepo.findAllByTeacherQualifications_Degree(degree);
    }
}
