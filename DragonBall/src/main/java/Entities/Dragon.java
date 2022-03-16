package Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Dragon")
public class Dragon extends MainCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = -1276536376569244797L;


}