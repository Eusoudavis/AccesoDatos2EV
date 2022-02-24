package Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

//De cada taxi: precio, matricula,numero de plazas.
//Cando empeza o turno dun taxista asignaselle un dos taxis que non está sendo usado por naide. Cada taxista,
// durante a súa xornada laboral, e ata que conclúa, será responsable do taxi asignado.
// Cando finaliza o traballo dun taxista, devolve o taxi utilizado, que estará libre para asignarllo a outro traballador.
@Entity
@Data
public class Taxi implements Serializable {
    @Serial
    private static final long serialVersionUID = -2547379875876116317L;

    @Id
    @Column(name = "carRegistrationNumber", nullable = false)
    private String carRegistrationNumber;

    @Column(name = "value", nullable = false)
    private int value;

    @Column(name = "nSeats", nullable = false)
    private int nSeats;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @ManyToMany(mappedBy = "taxis")
    List<TaxiDriver> taxiDrivers;

}
