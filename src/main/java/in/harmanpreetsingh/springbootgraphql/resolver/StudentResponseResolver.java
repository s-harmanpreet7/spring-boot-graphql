package in.harmanpreetsingh.springbootgraphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import in.harmanpreetsingh.springbootgraphql.enums.SubjectNameFilter;
import in.harmanpreetsingh.springbootgraphql.response.StudentResponse;
import in.harmanpreetsingh.springbootgraphql.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, SubjectNameFilter subjectNameFilter) {
        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

        if (Objects.nonNull(studentResponse.getStudent().getLearningSubjects())) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if(subjectNameFilter.name().equalsIgnoreCase(subjectNameFilter.All.name())) {
                    learningSubjects.add(new SubjectResponse(subject));
                } else if(subjectNameFilter.name().equalsIgnoreCase((subject.getSubjectName()))) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }
        return learningSubjects;
    }

    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
