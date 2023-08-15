package org.school.service.dao.impl;

import java.util.List;
import org.school.model.Course;
import org.school.model.ResponseObject;
import org.school.service.CourseRepo;
import org.school.service.dao.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        super();
        this.courseRepo = courseRepo;
    }

    @Override
    public ResponseObject addCourse(Course course) {
        ResponseObject responseObject = new ResponseObject();
        try {
            long id = courseRepo.save(course).getId();
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
    public Course getCourse(long id) {
        return null;
    }

    @Override
    public Course getCourse(String name) {
        return null;
    }

    @Override
    public ResponseObject updateCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }
}
