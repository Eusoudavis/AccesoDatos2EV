package Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Repostaxe implements Serializable {
    @Serial
    private static final long serialVersionUID = -794818740698281161L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "data", nullable = false)
    private String data;
    @Column(name = "importe", nullable = false)
    private double importe;

    @Override
    public String toString() {
        return "Repostaxe{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", importe=" + importe +
                '}';
    }
}
