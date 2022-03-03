package Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    private String marcar;
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @OneToOne(mappedBy = "ordenador")
    private Alumno alumno;

}
