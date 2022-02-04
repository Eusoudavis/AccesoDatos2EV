package Entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@Entity
@NamedQuery(name="numEmpregados" ,query = "Select l.puesto, count(l.nombre) from Empregado l group by l.puesto ")
@Table(name = "empleado")
public class Empregado implements Serializable {

    @Serial
    private static final long serialVersionUID = 292161082705958905L;

    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private Double sueldo;
    @Column(name = "oficina")
    private int oficina;
    @Basic(optional = false)
    @Column(name = "puesto")
    private String puesto;
    
	public Empregado() {
		super();
	}

	public Empregado(String dni, String nombre, Double sueldo, int oficina, String posto) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.oficina = oficina;
		this.puesto = posto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public int getOficina() {
		return oficina;
	}

	public void setOficina(int oficina) {
		this.oficina = oficina;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empregado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + ", oficina=" + oficina
				+ ", posto=" + puesto + "]";
	}

	
    
}
