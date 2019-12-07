package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carreraprofesional database table.
 * 
 */
@Entity
@NamedQuery(name="Carreraprofesional.findAll", query="SELECT c FROM Carreraprofesional c")
public class Carreraprofesional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcarreraprofe;

	private String carrera;

	@Column(name="created_at")
	private String createdAt;

	private String estado;

	private String infoadicional;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to Computadora
	@OneToMany(mappedBy="carreraprofesional")
	private List<Computadora> computadoras;

	public Carreraprofesional() {
	}

	public int getIdcarreraprofe() {
		return this.idcarreraprofe;
	}

	public void setIdcarreraprofe(int idcarreraprofe) {
		this.idcarreraprofe = idcarreraprofe;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInfoadicional() {
		return this.infoadicional;
	}

	public void setInfoadicional(String infoadicional) {
		this.infoadicional = infoadicional;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Computadora> getComputadoras() {
		return this.computadoras;
	}

	public void setComputadoras(List<Computadora> computadoras) {
		this.computadoras = computadoras;
	}

	@Override
	public String toString() {
		return "Carreraprofesional [idcarreraprofe=" + idcarreraprofe + ", carrera=" + carrera + ", createdAt="
				+ createdAt + ", estado=" + estado + ", infoadicional=" + infoadicional + ", updatedAt=" + updatedAt
				+ ", computadoras=" + computadoras + "]";
	}



}