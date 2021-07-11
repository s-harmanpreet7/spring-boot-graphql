package in.harmanpreetsingh.springbootgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"in.harmanpreetsingh.springbootgraphql.service",
        "in.harmanpreetsingh.springbootgraphql.query",
        "in.harmanpreetsingh.springbootgraphql.resolver",
        "in.harmanpreetsingh.springbootgraphql.mutation"})
@EntityScan("in.harmanpreetsingh.springbootgraphql.entity")
@EnableJpaRepositories("in.harmanpreetsingh.springbootgraphql.repository")
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

}
