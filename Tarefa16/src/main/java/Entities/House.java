package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class House implements Serializable {
    @Serial
    private static final long serialVersionUID = -1987519528623130072L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "houseId", nullable = false)
    private int houseId;

    @Column(name = "houseName", nullable = false)
    private String houseName;

    @OneToMany(mappedBy = "house")
    private List<Player> players;

    @Override
    public String toString() {
        return "-------------------Team{" +
                "id='" + houseId + '\'' +
                ", teamName='" + houseName + '\'' +
                '}'+"------------------";
    }
}
