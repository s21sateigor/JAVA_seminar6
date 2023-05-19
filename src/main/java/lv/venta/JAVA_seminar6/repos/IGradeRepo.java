package lv.venta.JAVA_seminar6.repos;

import lv.venta.JAVA_seminar6.models.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGradeRepo extends CrudRepository<Grade, Long> {

    ArrayList<Grade> findByStudentIds(long id);

    ArrayList<Grade> findByCourseIdc(long id);

}