package Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Xornalista implements Serializable {
    @Serial
    private static final long serialVersionUID = -1755544336644215492L;

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "name")
    private String name;

    @Column(name = "telf")
    private int telf;

    @OneToMany (mappedBy = "xornalista", orphanRemoval = true)
    List<Artigos> artigos;

    @Override
    public String toString() {
        return "Xornalista{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", telf=" + telf +
                '}';
    }
}
