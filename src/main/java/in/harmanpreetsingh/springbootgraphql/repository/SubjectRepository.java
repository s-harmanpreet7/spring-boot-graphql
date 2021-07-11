package in.harmanpreetsingh.springbootgraphql.repository;

import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
