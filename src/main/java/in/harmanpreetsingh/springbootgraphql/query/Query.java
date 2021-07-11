package in.harmanpreetsingh.springbootgraphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String firstQuery() {
        return "First Query";
    }

    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
