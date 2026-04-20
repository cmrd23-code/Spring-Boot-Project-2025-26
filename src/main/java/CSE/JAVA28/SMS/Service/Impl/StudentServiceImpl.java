package CSE.JAVA28.SMS.Service.Impl;

import CSE.JAVA28.SMS.DTO.StudentDTO;
import CSE.JAVA28.SMS.Entity.StudentEntity;
import CSE.JAVA28.SMS.Repository.StudentRepository;
import CSE.JAVA28.SMS.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<StudentDTO> st=new ArrayList<>();
        st.add(new StudentDTO(1L,"abhay",95.0));
        return st;
    }

    @Override
    public List<StudentDTO> getDbStudents() {
        List<StudentEntity> se= studentRepository.findAll();
        List<StudentDTO>s=new ArrayList<>();
        for(StudentEntity x: se)
          s.add(modelMapper.map(x,StudentDTO.class));
     return s;

    }

    @Override
    public StudentDTO geStudentById(Long id) {
        Optional<StudentEntity> se=studentRepository.findById(id);
        return modelMapper.map(se,StudentDTO.class);
    }

    @Override
    public void deleteStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public void addStudent(StudentDTO s) {
        studentRepository.save(modelMapper.map(s,StudentEntity.class));
    }
}
