package Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table()
public class GoodCharacter extends MainCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = -2305990919471992625L;

    @Column(name = "ressurrectionCount", nullable = false)
    private Integer ressurrectionCount;
}