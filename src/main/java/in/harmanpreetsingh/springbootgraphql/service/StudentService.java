package in.harmanpreetsingh.springbootgraphql.service;

import in.harmanpreetsingh.springbootgraphql.entity.Address;
import in.harmanpreetsingh.springbootgraphql.entity.Student;
import in.harmanpreetsingh.springbootgraphql.entity.Subject;
import in.harmanpreetsingh.springbootgraphql.repository.AddressRepository;
import in.harmanpreetsingh.springbootgraphql.repository.StudentRepository;
import in.harmanpreetsingh.springbootgraphql.repository.SubjectRepository;
import in.harmanpreetsingh.springbootgraphql.request.CreateStudentRequest;
import in.harmanpreetsingh.springbootgraphql.request.CreateSubjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final SubjectRepository subjectRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student createStudent (CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<Subject>();

        if(createStudentRequest.getLearningSubjects() != null) {
            for (CreateSubjectRequest createSubjectRequest :
                    createStudentRequest.getLearningSubjects()) {
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepository.saveAll(subjectsList);

        }

        student.setLearningSubjects(subjectsList);

        return student;
    }
}
