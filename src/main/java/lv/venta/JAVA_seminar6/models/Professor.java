package lv.venta.JAVA_seminar6.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Table(name = "professor_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Professor {

    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)

    private long idp;
    //TODO add data JPA annotations (@column utt)
    //TODO add validation annotations (@min @max @pattern @notnull utt)

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

    @OneToOne(mappedBy = "professor")
    @ToString.Exclude
    private Course course;

    public Professor(String name, String surname, Degree degree){
        this.name = name;
        this.surname = surname;
        this.degree = degree;
    }

}

