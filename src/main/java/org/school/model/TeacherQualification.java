package org.school.model;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher-qualification")
public class TeacherQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "degree")
    private String degree;

    @Column(name = "course")
    private String course;

    @Column(name = "specialization")
    private String specialization;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherQualification that = (TeacherQualification) o;
        return Objects.equals(degree, that.degree)
                && Objects.equals(course, that.course)
                && Objects.equals(specialization, that.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(degree, course, specialization);
    }
}
