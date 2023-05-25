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
public class Student extends Person {
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Collection<Grade> grades;

    public Student(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String name,
                   @NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String surname) {
        super(name, surname);
    }

}
