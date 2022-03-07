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
    @Column(name = "nij", nullable = false)
    private String nij;
    @Column(name = "playerName", nullable = false)
    private String playerName;
    @Column(name = "maxScore", nullable = false)
    private String maxScore;

    @ManyToOne
    private Team team;

    @Override
    public String toString() {
        return "---------------Player{" +
                "nij='" + nij + '\'' +
                ", playerName='" + playerName + '\'' +
                ", maxScore='" + maxScore + '\'' +
                '}'+"-----------------";
    }


}
