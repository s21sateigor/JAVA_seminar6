package lv.venta.JAVA_seminar6.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Collection;

@Table(name = "professor_table") //table in DB
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)

    private long idp;
    @Column(name = "Name") // H2 title
    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Only Latin letters")
    private String name;

    @Column(name = "Surname") // H2 title
    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Only Latin letters")
    private String surname;

    @Column(name = "Degree")
    @NotNull
    private Degree degree;

    @ManyToMany
    @JoinTable(name = "prof_course_table", joinColumns = @JoinColumn(name = "Idc"), inverseJoinColumns = @JoinColumn(name = "Idp"))
    @ToString.Exclude
    private Collection<Course> courses = new ArrayList<>();

    public Professor(String name, String surname, Degree degree){
        this.name = name;
        this.surname = surname;
        this.degree = degree;
    }

    public void addCourse(Course inputCourse){
        if(!courses.contains(inputCourse)){
            courses.add(inputCourse);
        }
    }

    public void removeCourse(Course inputCourse){
        if(courses.contains(inputCourse)){
            courses.remove(inputCourse);
        }
    }

}

