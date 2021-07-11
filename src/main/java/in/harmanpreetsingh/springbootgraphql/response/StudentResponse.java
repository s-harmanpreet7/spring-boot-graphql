package in.harmanpreetsingh.springbootgraphql.response;

import in.harmanpreetsingh.springbootgraphql.entity.Student;
import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public StudentResponse(Student student) {
        this.id = id;
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();


        if(Objects.nonNull(student.getLearningSubjects())) {
            ArrayList<SubjectResponse> learningSubjects =  new ArrayList<>();
            for (Subject subject : student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }

        }
    }
}
