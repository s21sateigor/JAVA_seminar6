package lv.venta.JAVA_seminar6.services.impl;

import lv.venta.JAVA_seminar6.models.Course;
import lv.venta.JAVA_seminar6.models.Grade;
import lv.venta.JAVA_seminar6.models.Professor;
import lv.venta.JAVA_seminar6.models.Student;
import lv.venta.JAVA_seminar6.repos.ICourseRepo;
import lv.venta.JAVA_seminar6.repos.IGradeRepo;
import lv.venta.JAVA_seminar6.repos.IProfessorRepo;
import lv.venta.JAVA_seminar6.repos.IStudentRepo;
import lv.venta.JAVA_seminar6.services.IFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FilteringServiceImpl implements IFilteringService{

    @Autowired
    private IProfessorRepo profRepo;

    @Autowired
    private IStudentRepo studRepo;

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IGradeRepo gradeRepo;


    @Override
    public ArrayList<Student> retrieveAllStudents() {
        return (ArrayList<Student>) studRepo.findAll();
    }

    @Override
    public ArrayList<Grade> retrieveAllGrades() {
        return (ArrayList<Grade>) gradeRepo.findAll();
    }

    @Override
    public ArrayList<Course> retrieveAllCourses() {
        // TODO Auto-generated method stub
        return (ArrayList<Course>) courseRepo.findAll();
    }

    @Override
    public ArrayList<Professor> retrieveAllProfessors() {
        // TODO Auto-generated method stub
        return (ArrayList<Professor>) profRepo.findAll();
    }

    @Override
    public ArrayList<Grade> retrieveAllGradesByStudentId(long id) throws Exception {
        if(id > 0) {
            ArrayList<Grade> filteredResults = gradeRepo.findByStudentIds(id);
            return filteredResults;
        }
        else
        {
            throw new Exception("Incorrect ID");
        }
    }

    @Override
    public ArrayList<Course> retrieveAllCoursesByStudentId(long id) throws Exception {
        if(id > 0) {
            ArrayList<Course> filteredResults = courseRepo.findByGradesStudentIds(id);
            return filteredResults;
        }
        else
        {
            throw new Exception("Incorrect ID");
        }
    }

    @Override
    public ArrayList<Course> retrieveAllCoursesByProfessorId(long id)  throws Exception{
        if(id > 0) {
            ArrayList<Course> filteredResults = courseRepo.findAllByProfessorsIdp(id);
            return filteredResults;
        }
        else
        {
            throw new Exception("Incorrect ID");
        }
    }


    @Override
    public float calculateAvgGradeInCourseId(long id) throws Exception{
        if(id > 0) {
            ArrayList<Grade> filteredResults = gradeRepo.findByCourseIdc(id);
            float sum = 0;
            for(Grade temp: filteredResults) {
                sum += temp.getGvalue();
            }
            return sum/filteredResults.size();
        }
        else
        {
            throw new Exception("Incorrect ID");
        }
    }

}