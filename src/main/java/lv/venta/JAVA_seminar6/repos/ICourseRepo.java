package lv.venta.JAVA_seminar6.repos;

import lv.venta.JAVA_seminar6.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepo extends CrudRepository<Course, Long> {
}
