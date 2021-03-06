package entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "empleado")
public class Empregado implements Serializable {

	private static final long serialVersionUID = 7604718708707817500L;
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
    private String posto;
    
	public Empregado() {
		super();
	}

	public Empregado(String dni, String nombre, Double sueldo, int oficina, String posto) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.oficina = oficina;
		this.posto = posto;
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

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empregado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + ", oficina=" + oficina
				+ ", posto=" + posto + "]";
	}

	
    
}
