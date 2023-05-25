package lv.venta.JAVA_seminar6.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Table(name = "professor_table") //table in DB
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Person{
    @Column(name = "Degree")
    @NotNull
    private Degree degree;

    @ManyToMany(mappedBy = "professors")
    @ToString.Exclude
    private Collection<Course> courses = new ArrayList<>();

    public Professor(String name, String surname, Degree degree){
        super(name, surname);
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

