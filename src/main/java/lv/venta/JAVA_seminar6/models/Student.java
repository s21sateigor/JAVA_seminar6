package lv.venta.JAVA_seminar6.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Collection;

@Table(name = "student_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Column(name = "Ids")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private long ids;

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
    @ToString.Exclude
    private Collection<Grade> grades;

    public Student(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String name,
                   @NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String surname) {
        this.name = name;
        this.surname = surname;
    }

}
