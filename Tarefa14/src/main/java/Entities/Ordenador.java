package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Ordenador implements Serializable {
    @Serial
    private static final long serialVersionUID = -2301069332042597519L;
    @Id
    @Column(name = "idPC", nullable = false)
    private String idPC;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @OneToOne
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    private Alumno alumno;

    @Override
    public String toString() {
        return "Ordenador{" +
                "idPC='" + idPC + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
