package org.school.service.dao;

import java.util.List;
import org.school.model.Course;
import org.school.model.ResponseObject;

public interface CourseService {
    ResponseObject addCourse(Course course);

    Course getCourse(long id);

    Course getCourse(String name);

    ResponseObject updateCourse(Course course);

    List<Course> getAllCourse();
}
