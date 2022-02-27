package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

//De cada taxista: nome, DNI, data de nacemento
//Cando empeza o turno dun taxista asignaselle un dos taxis que non está sendo usado por naide. Cada taxista, durante a súa xornada laboral, e ata que conclúa, será responsable do taxi asignado.
// Cando finaliza o traballo dun taxista, devolve o taxi utilizado, que estará libre para asignarllo a outro traballador.
@Entity
@Data
public class TaxiDriver implements Serializable {
    @Serial
    private static final long serialVersionUID = 3469854856962154676L;

    @ManyToMany
    @JoinColumn(name = "carRegistrationNumber")
    List<Taxi> taxis;

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "birthdate", nullable = false)
    private String birthdate;
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", active=" + active +
                '}';
    }
}
