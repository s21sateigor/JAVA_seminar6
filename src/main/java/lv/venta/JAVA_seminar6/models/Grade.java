package lv.venta.JAVA_seminar6.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "grade_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {

    @Column(name = "Idg")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private long idg;

    @Column(name = "Gvalue")
    @Min(value = 0)
    @Max(value = 10)
    private int gvalue;

    @ManyToOne
    @JoinColumn(name = "Ids")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Idc")
    private Course course;

    public Grade(@Min(0) @Max(10) int gvalue, Student student, Course course) {
        this.gvalue = gvalue;
        this.student = student;
        this.course = course;
    }
}
