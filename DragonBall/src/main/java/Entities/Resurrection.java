package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Resurrection implements Serializable {
    @Serial
    private static final long serialVersionUID = 3439247259171133915L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    private GoodCharacter goodCharacter;

    @ManyToOne
    private Dragon dragon;

}
