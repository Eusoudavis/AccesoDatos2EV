package Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/*
* Realiza unha aplicación para xestionar unha biblioteca composta de manuales e de revistas.
* De cada manual precisamos gardar  a sinatura (que sirve para identificalo),
* o titulo e o prezo. Unha revista é un tipo especial de manual, da que, ademais, temos que almacenar o mes de publicación (un número de 1 ao 12), o número de páxinas.
* A aplicación terá a opción de engadir, eliminar e consultar a
* infromación dos manuais e revistas que temos.
* */

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Manual implements Serializable {

    @Serial
    private static final long serialVersionUID = 2746135738573587694L;

    @Id
    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;


}
