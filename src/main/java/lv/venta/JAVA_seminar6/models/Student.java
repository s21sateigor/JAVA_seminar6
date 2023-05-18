package lv.venta.JAVA_seminar6.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Table(name = "student_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Column(name = "Idst")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private long idst;

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

    @OneToMany(mappedBy = "student")
    private Collection<Grade> grades;


}
