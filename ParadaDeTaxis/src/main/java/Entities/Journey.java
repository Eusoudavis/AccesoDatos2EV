package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table
public class Journey implements Serializable {
    @Serial
    private static final long serialVersionUID = 5320611700502702573L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "taxiDriverDNI")
    protected TaxiDriver taxiDriver;
    @ManyToOne
    @JoinColumn(name = "taxiNumber")
    protected Taxi taxi;
    protected String date;
    protected String initHour;
    protected String endHour;

    @Override
    public String toString() {
        return "\nJourney{\n" +
                taxiDriver +
                "\n" + taxi + "\n" +
                '}';
    }
}
