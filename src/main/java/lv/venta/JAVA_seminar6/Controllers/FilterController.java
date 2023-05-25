package lv.venta.JAVA_seminar6.Controllers;

import lv.venta.JAVA_seminar6.services.IFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilterController
{
    @Autowired
    private IFilteringService filteringService;

    @GetMapping("/info/showAllStudents")
    public String getAllStudentsFunc(Model model){
        model.addAttribute("students", filteringService.retrieveAllStudents());
        return  "all-students-page";
    }

    //TODO add this for Professor
    @GetMapping("/info/showAllProfessors")
    public String getAllProfessorsFunc(Model model){
        model.addAttribute("professors", filteringService.retrieveAllProfessors());
        return  "all-professors-page";
    }

    //TODO add this for Grades
    @GetMapping("/info/showAllGrades")
    public String getAllGradesFunc(Model model){
        model.addAttribute("grades", filteringService.retrieveAllGrades());
        return  "all-grades-page";
    }

    //TODO add this for Courses
    @GetMapping("/info/showAllCourses")
    public String getAllCoursesFunc(Model model){
        model.addAttribute("courses", filteringService.retrieveAllCourses());
        return  "all-courses-page";
    }


    @GetMapping("/filter/filterGradesByStudent/{id}")
    public String getAllGradesByStudentId(@PathVariable("id") long id, Model model) {
        try {
            model.addAttribute("grades", filteringService.retrieveAllGradesByStudentId(id));
            return "all-grades-page";
        } catch (Exception e){
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/filter/filterCoursesByStudent")
    public String getAllCoursesByStudentId(@RequestParam(name = "id") long id, Model model) {
        try {
            model.addAttribute("courses", filteringService.retrieveAllCoursesByStudentId(id));
            return "all-courses-page";
        } catch (Exception e){
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }
}
