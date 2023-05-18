package lv.venta.JAVA_seminar6.repos;

import lv.venta.JAVA_seminar6.models.Professor;
import org.springframework.data.repository.CrudRepository;


public interface IProfessorRepo extends CrudRepository<Professor, Long> {

}
