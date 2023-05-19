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

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class JavaSeminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar6Application.class, args);
	}

	@Bean
	public CommandLineRunner testModel(IProfessorRepo professorRepo, IStudentRepo studentRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo){


		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Juris", "Zagars", Degree.phd);
				Professor p2 = new Professor("Dmitrijs", "Smirnovs", Degree.phd);
				Professor p3 = new Professor("Karina", "Skirmante", Degree.mg);

				professorRepo.save(p1);
				professorRepo.save(p2);
				professorRepo.save(p3);

				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Baiba", "Kalnina");
				studentRepo.save(s1);
				studentRepo.save(s2);

				Course c1 = new Course("Haosa teorija", 4, new ArrayList<>(Arrays.asList(p1)));
				Course c2 = new Course("Ekonomikas pamati", 2, new ArrayList<>(Arrays.asList(p2)));
				Course c3 = new Course("Dabaszinatnu pamati", 2, new ArrayList<>(Arrays.asList(p1)));
				Course c4 = new Course("Java", 4, new ArrayList<>(Arrays.asList(p2, p3)));
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				courseRepo.save(c4);

				c1.addProfessor(p1);
				c2.addProfessor(p2);
				c3.addProfessor(p1);
				c4.addProfessor(p2);
				c4.addProfessor(p3);

				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				courseRepo.save(c4);

				gradeRepo.save(new Grade(10, s1, c1));
				gradeRepo.save(new Grade(9, s2, c1));
				gradeRepo.save(new Grade(8, s1, c2));
				gradeRepo.save(new Grade(7, s2, c2));



			}
		};
	}

}
