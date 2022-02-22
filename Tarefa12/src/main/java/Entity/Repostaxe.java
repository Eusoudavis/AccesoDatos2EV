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
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Serial
    private static final long serialVersionUID = -794818740698281161L;

    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "importe", nullable = false)
    private Double importe;
}
