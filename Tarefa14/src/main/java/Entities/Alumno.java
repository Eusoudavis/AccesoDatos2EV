package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Alumno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1749212192635233729L;

    @Id
    @Column(name = "id_alumno", nullable = false)
    private String idAlumno;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPC", referencedColumnName = "idPC")
    private Ordenador ordenador;
}
