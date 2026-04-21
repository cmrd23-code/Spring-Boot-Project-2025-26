package CSE.JAVA28.SMS.Controller;

import CSE.JAVA28.SMS.DTO.StudentDTO;
import CSE.JAVA28.SMS.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ArrayList<StudentDTO> getStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/studentsDb")
    public List<StudentDTO> getDbStudents(){
        return studentService.getDbStudents();
    }

    @GetMapping("/studentsDb/{id}")
    public StudentDTO getDbStudents(@PathVariable Long id){
        return studentService.geStudentById(id);
    }

    @DeleteMapping("/delStudents")
    public void deleteAllData() {
        studentService.deleteStudents();
    }

    @PostMapping("/addStudents")
    public void addStudents(@RequestBody StudentDTO s){
        studentService.addStudent(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO s) {
        StudentDTO updatedStudent = studentService.update(id, s);
        return ResponseEntity.ok(updatedStudent);
    }
}
