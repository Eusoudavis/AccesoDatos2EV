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
    @Column(name = "idAlumno", nullable = false)
    private String idAlumno;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @OneToOne
    @JoinColumn(name = "idPC", referencedColumnName = "idPC")
    private Ordenador ordenador;

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno='" + idAlumno + '\'' +
                ", nome='" + nome + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
