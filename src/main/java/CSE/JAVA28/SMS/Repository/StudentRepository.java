package CSE.JAVA28.SMS.Repository;

import CSE.JAVA28.SMS.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> { }
