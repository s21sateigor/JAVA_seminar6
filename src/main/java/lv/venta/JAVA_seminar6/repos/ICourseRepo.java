package lv.venta.JAVA_seminar6.repos;

import lv.venta.JAVA_seminar6.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ICourseRepo extends CrudRepository<Course, Long> {

    ArrayList<Course> findByGradesStudentIdp(long id);

    ArrayList<Course> findAllByProfessorsIdp(long id);

}
