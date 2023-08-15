package org.school.resource.v1;

import java.util.List;
import org.school.model.ResponseObject;
import org.school.model.Teacher;
import org.school.service.dao.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/teacher")
public class TeacherResourceV1 {
    private TeacherService teacherService;

    public TeacherResourceV1(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    @PreAuthorize("hasRole('POST')")
    public ResponseEntity<ResponseObject> addTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasRole('GET')")
    public ResponseEntity<Teacher> getTeacher(
            @RequestParam(name = "teacherId", required = false) Long teacherId,
            @RequestParam(name = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return new ResponseEntity<>(teacherService.getTeacher(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(teacherService.getTeacher(teacherId), HttpStatus.OK);
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('PUT')")
    public ResponseEntity<ResponseObject> updateTeacher(
            @RequestBody Teacher teacher,
            @RequestParam(name = "teacherId", required = true) Long id) {
        return new ResponseEntity<>(teacherService.updateTeacher(teacher, id), HttpStatus.OK);
    }

    @GetMapping("all")
    @PreAuthorize("hasRole('GET')")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("degree")
    @PreAuthorize("hasRole('GET')")
    public ResponseEntity<List<Teacher>> getAllTeachersWithDegree(
            @RequestParam("degree") String degree) {
        return new ResponseEntity<>(teacherService.getAllTeachersWithDegree(degree), HttpStatus.OK);
    }
}
