package in.harmanpreetsingh.springbootgraphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import in.harmanpreetsingh.springbootgraphql.request.Request;
import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import in.harmanpreetsingh.springbootgraphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String fullName(Request request) {
        return request.getFirstName() + " " + request.getLastName();
    }

    public StudentResponse getStudent(long id) {
        return new StudentResponse(studentService.getStudentById(id));
    }
}
