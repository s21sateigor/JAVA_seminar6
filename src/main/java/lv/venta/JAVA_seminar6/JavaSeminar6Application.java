package lv.venta.JAVA_seminar6;

import lv.venta.JAVA_seminar6.models.*;
import lv.venta.JAVA_seminar6.repos.ICourseRepo;
import lv.venta.JAVA_seminar6.repos.IGradeRepo;
import lv.venta.JAVA_seminar6.repos.IProfessorRepo;
import lv.venta.JAVA_seminar6.repos.IStudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSeminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar6Application.class, args);

		//TODO create new branch and go to it
		//TODO change linkage between Professor and Course to ManyToMany
		//TODO create adding functions for both Collections
		//TODO change testModel function to add 2 courses for Zagars and Smirnovs
	}

}
