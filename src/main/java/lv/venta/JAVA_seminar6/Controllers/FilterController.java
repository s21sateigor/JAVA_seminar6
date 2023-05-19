package lv.venta.JAVA_seminar6.Controllers;

import lv.venta.JAVA_seminar6.services.IFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
