package in.harmanpreetsingh.springbootgraphql.repository;

import in.harmanpreetsingh.springbootgraphql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    Student findByLastNameAndFirstName(String lastName, String firstName);

    List<Student> findByFirstNameOrLastName (String firstName, String lastName);

    List<Student> findByFirstNameIn (List<String> firstNames);

    @Query("from Student where firstName = :firstName and lastName = :lastName")
    Student getByLastNameAndFirstName(String lastName, @Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query("update Student set firstName = :firstName where id = :id")
    Integer updateFirstName(Long id, String firstName);

    List<Student> findByAddressCity(String city);

    @Query("from Student where address.city = :city")
    List<Student> getByAddressCity(String city);
}
