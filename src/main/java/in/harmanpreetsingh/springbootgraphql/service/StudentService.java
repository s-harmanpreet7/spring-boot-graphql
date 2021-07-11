package in.harmanpreetsingh.springbootgraphql.service;

import in.harmanpreetsingh.springbootgraphql.entity.Student;
import in.harmanpreetsingh.springbootgraphql.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }
}
