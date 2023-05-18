package lv.venta.JAVA_seminar6.models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
