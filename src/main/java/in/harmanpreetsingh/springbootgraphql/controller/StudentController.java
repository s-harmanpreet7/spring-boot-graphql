package in.harmanpreetsingh.springbootgraphql.controller;

import in.harmanpreetsingh.springbootgraphql.entity.Student;
import in.harmanpreetsingh.springbootgraphql.request.CreateStudentRequest;
import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import in.harmanpreetsingh.springbootgraphql.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents () {
        List<Student> studentList = studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getFirstNameById/{id}")
    public String getFirstNameById (@PathVariable long id) {
        return studentService.getFirstNameById(id);
    }

    @GetMapping("getLastNameById/{id}")
    public String getLastNameById (@PathVariable long id) {
        return studentService.getLastNameById(id);
    }

    @PostMapping("create")
    public StudentResponse createStudent (@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        Student student = studentService.createStudent(createStudentRequest);

        return new StudentResponse(student);
    }
}
