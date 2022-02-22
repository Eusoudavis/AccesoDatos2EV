package Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Factura extends Repostaxe implements Serializable {
    @Serial
    private static final long serialVersionUID = 1670760995474407439L;

    @Column(name = "dni", nullable = false)
    private Cliente cliente;

    @Column(name = "matricula", nullable = false)
    private String matricula;
}
