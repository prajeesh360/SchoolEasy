package org.school.resource.v1;

import org.school.model.ResponseObject;
import org.school.model.Student;
import org.school.service.dao.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student")
public class StudentResourceV1 {
    @Autowired private StudentService studentService;

    @PostMapping
    @PreAuthorize("hasRole('POST')")
    public ResponseEntity<ResponseObject> addStudent(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }
}
