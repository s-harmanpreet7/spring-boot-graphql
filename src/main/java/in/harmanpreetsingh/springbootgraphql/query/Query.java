package in.harmanpreetsingh.springbootgraphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import in.harmanpreetsingh.springbootgraphql.request.Request;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String firstQuery() {
        return "First Query";
    }

    public String fullName(Request request) {
        return request.getFirstName() + " " + request.getLastName();
    }
}
