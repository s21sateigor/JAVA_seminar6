package lv.venta.JAVA_seminar6.repos;

import lv.venta.JAVA_seminar6.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Long> {

}
