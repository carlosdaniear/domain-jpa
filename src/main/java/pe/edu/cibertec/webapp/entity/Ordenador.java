package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ordenador database table.
 * 
 */
@Entity
@NamedQuery(name="Ordenador.findAll", query="SELECT o FROM Ordenador o")
public class Ordenador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String categoria;

	private String marca;

	private String precio;

	private String punto;

	public Ordenador() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPunto() {
		return this.punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

}