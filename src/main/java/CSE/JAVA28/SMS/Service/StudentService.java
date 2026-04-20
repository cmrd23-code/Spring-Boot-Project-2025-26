package CSE.JAVA28.SMS.Service;

import CSE.JAVA28.SMS.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface StudentService {
    ArrayList<StudentDTO> getAllStudents();
    List<StudentDTO> getDbStudents();
    StudentDTO geStudentById(Long id);
    void deleteStudents();
    void addStudent(StudentDTO s);
}
