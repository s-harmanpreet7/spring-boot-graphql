package in.harmanpreetsingh.springbootgraphql.response;

import in.harmanpreetsingh.springbootgraphql.entity.Student;
import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class StudentResponse {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects;
    private String fullName;

    // This field is only for internal logic, DO NOT PUT IN SCHEMA
    private Student student;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();
        this.student = student;
    }
}
