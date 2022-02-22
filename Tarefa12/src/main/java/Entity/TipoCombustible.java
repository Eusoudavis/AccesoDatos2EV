package Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Entity()
@Data
public class TipoCombustible implements Serializable {
    @Serial
    private static final long serialVersionUID = -6007785088597633597L;

    @Id
    @Column(name = "idCombustible", nullable = false)
    private Long idCombustible;

    @Column(name = "fuel", nullable = false)
    private String fuel;

}
