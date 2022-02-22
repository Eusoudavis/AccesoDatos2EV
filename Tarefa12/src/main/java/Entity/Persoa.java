package Entity;

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
public class Persoa implements Serializable {
    @Serial
    private static final long serialVersionUID = -8636384700031003648L;

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @OneToMany(mappedBy = "persoa", orphanRemoval = true)
    List<Factura> facturas;
}
