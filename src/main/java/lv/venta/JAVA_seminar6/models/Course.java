package lv.venta.JAVA_seminar6.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Table(name = "course_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "Idp")
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private Collection<Grade> grades;

}
