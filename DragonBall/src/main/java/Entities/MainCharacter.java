package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "main_character")
@Inheritance(strategy = InheritanceType.JOINED)
public class MainCharacter implements Serializable {
    @Serial
    private static final long serialVersionUID = 471701040914931625L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "ki", nullable = false)
    private Integer ki;

    @Column(name = "alive", nullable = false)
    private Boolean alive;

    @Column(name = "planet", nullable = false)
    private String planet;
}