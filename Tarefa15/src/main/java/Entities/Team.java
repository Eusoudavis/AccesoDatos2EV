package Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Team implements Serializable {
    @Serial
    private static final long serialVersionUID = -1987519528623130072L;

    @Id
    @Column(name = "nie", nullable = false)
    private String nie;

    @Column(name = "teamName", nullable = false)
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @Override
    public String toString() {
        return "-------------------Team{" +
                "nie='" + nie + '\'' +
                ", teamName='" + teamName + '\'' +
                '}'+"------------------";
    }
}
