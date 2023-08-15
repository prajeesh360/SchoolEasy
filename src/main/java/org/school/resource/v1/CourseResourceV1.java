package org.school.resource.v1;

import org.school.model.Course;
import org.school.model.ResponseObject;
import org.school.service.dao.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/course")
public class CourseResourceV1 {

    @Autowired private CourseService courseService;

    @PostMapping
    @PreAuthorize("hasRole('POST')")
    public ResponseEntity<ResponseObject> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.OK);
    }
}
