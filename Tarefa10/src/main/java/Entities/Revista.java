package Entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Revista extends Manual implements Serializable {
    @Serial
    private static final long serialVersionUID = -2927072846658511710L;

    @Column(name = "date")
    private int date;

    @Column(name = "pages")
    private int pages;

    @Override
    public String toString() {
        return "Revista{" +
                "date=" + date +
                ", pages=" + pages +
                "} " + super.toString();
    }
}
