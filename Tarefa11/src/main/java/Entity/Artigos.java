package Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Artigos implements Serializable {
    @Id
    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Serial
    private static final long serialVersionUID = -7423981346181552972L;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "word")
    private int word;

    @ManyToOne
    Xornalista xornalista;

}
