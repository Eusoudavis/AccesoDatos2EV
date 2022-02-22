package Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cando esto ocorre, hai que almacenar a cantidade de litros, o tipo de combustible
 * (gasoil, gasolina 95, gasolina 98..) e o importe total do combustible.
 */
@Entity
@Data
//@NamedQuery(name="idMax" ,query = "Select MAX(l.id) as id from Enchido")
public class Enchido implements Serializable {

    @Serial
    private static final long serialVersionUID = 4892328824990430133L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "litros", nullable = false)
    private int litros;

    @Column(name = "importeTotal", nullable = false)
    private double importeTotal;

    @ManyToOne
    @JoinColumn(name = "idCombustible", nullable = false)
    TipoCombustible tipoCombustible;

}
