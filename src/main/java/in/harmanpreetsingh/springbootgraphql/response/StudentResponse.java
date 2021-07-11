package in.harmanpreetsingh.springbootgraphql.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    @JsonIgnore
    private long id;

    private String firstName;
    private String lastName;
}
