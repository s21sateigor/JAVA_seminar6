package lv.venta.JAVA_seminar6.models;


import jakarta.persistence.*;

@Table(name = "professor_table") //table in DB
@Entity
public class Professor {

    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;

    private String name;
    private String surname;
    
}

