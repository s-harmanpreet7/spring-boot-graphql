package in.harmanpreetsingh.springbootgraphql.controller;

import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Value("${app.name: Spring boot - GraphQL")
    private String appname;

    @GetMapping()
    public StudentResponse getStudent() {
        return new StudentResponse(1, "John", "Doe");
    }
}
