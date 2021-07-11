package in.harmanpreetsingh.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import in.harmanpreetsingh.springbootgraphql.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {
        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

        if (Objects.nonNull(studentResponse.getStudent().getLearningSubjects())) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }
}