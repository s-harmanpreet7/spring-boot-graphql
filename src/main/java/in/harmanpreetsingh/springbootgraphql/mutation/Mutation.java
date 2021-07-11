package in.harmanpreetsingh.springbootgraphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import in.harmanpreetsingh.springbootgraphql.request.CreateStudentRequest;
import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import in.harmanpreetsingh.springbootgraphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
