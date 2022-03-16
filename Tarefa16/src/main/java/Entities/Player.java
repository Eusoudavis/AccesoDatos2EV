package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = -4178481352576385699L;
    @Id
    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "playerName", nullable = false)
    private String playerName;

    @ManyToOne
    private House house;

    @Override
    public String toString() {
        return "---------------Player{" +
                "dni='" + dni + '\'' +
                ", playerName='" + playerName + '\''  +
                '}'+"-----------------";
    }
}
