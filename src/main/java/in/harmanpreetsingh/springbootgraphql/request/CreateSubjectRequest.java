package in.harmanpreetsingh.springbootgraphql.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubjectRequest {
    private String subjectName;
    private Double marksObtained;
}
