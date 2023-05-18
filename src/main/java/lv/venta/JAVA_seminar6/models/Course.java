package lv.venta.JAVA_seminar6.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Collection;

@Table(name = "course_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    private Collection<Professor> professor;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Collection<Grade> grades;

    public Course(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String title, @Min(1) @Max(20) int creditPoints, Professor professor) {
        this.title = title;
        this.creditPoints = creditPoints;
        this.professor = professor;
    }

}
