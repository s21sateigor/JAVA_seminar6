package lv.venta.JAVA_seminar6.services;

import lv.venta.JAVA_seminar6.models.Course;
import lv.venta.JAVA_seminar6.models.Grade;
import lv.venta.JAVA_seminar6.models.Professor;
import lv.venta.JAVA_seminar6.models.Student;

import java.util.ArrayList;

public interface IFilteringService {
    ArrayList<Student> retrieveAllStudents();
    ArrayList<Professor> retrieveAllProfessors();
    ArrayList<Course> retrieveAllCourses();
    ArrayList<Grade> retrieveAllGrades();
    ArrayList<Grade> retrieveAllGradesByStudentId(long id) throws Exception;
    ArrayList<Course> retrieveAllCoursesByStudentId(long id) throws Exception;
    ArrayList<Course> retrieveAllCoursesByProfessorId(long id) throws Exception;
    float calculateAvgGradeInCourseId(long id) throws Exception;


}
