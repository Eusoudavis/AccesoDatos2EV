package Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Factura extends Repostaxe implements Serializable {
    @Serial
    private static final long serialVersionUID = 1670760995474407439L;

    @ManyToOne
    @JoinColumn(name = "dni",  nullable = false)
    Persoa persoa;

    @Override
    public String toString() {
        return "Factura{" + super.toString();
    }
    public String toStringConPersoa() {
        return "Factura{" +
                "persoa=" + persoa +
                "} " + super.toString();
    }
}
