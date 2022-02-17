import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Xornalista implements Serializable {
    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Serial
    private static final long serialVersionUID = -1755544336644215492L;

    @Column(name = "name")
    private String name;

    @Column(name = "telf")
    private int telf;

    @OneToMany (mappedBy = "xornalista")
    List<Artigos> artigos;

}
