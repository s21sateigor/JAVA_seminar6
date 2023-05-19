package lv.venta.JAVA_seminar6.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Table(name = "course_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Course {

    @Column(name = "Idc")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private long idc;

    @Column(name = "Title") // H2 title
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters")
    private String title;

    @Column(name = "CreditPoints")
    @Min(value = 1)
    @Max(value = 20)
    private int creditPoints;

    @ManyToMany
    @JoinTable(name = "prof_course_table", joinColumns = @JoinColumn(name = "Idc"), inverseJoinColumns = @JoinColumn(name = "Idp"))
    @ToString.Exclude
    private Collection<Professor> professors = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Collection<Grade> grades;

    public Course(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String title, @Min(1) @Max(20) int creditPoints, ArrayList<Professor> professors) {
        this.title = title;
        this.creditPoints = creditPoints;
        this.professors = professors;
    }

    public void addProfessor(Professor inputProfessor){
        if(!professors.contains(inputProfessor)) {
            professors.add(inputProfessor);
        }
    }

    //TODO remove professor from the arraylist

    public void removeProfessor(Professor inputProfessor){
        if(professors.contains(inputProfessor)){
            professors.remove(inputProfessor);
        }
    }
}
