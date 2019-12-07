package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the puntosventa database table.
 * 
 */
@Entity
@NamedQuery(name="Puntosventa.findAll", query="SELECT p FROM Puntosventa p")
public class Puntosventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpuntos_venta")
	private int idpuntosVenta;

	private String celularcomercial;

	@Column(name="created_at")
	private String createdAt;

	private String descripcion;

	private String direccion;

	private String estado;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to Computadora
	@OneToMany(mappedBy="puntosventa")
	private List<Computadora> computadoras;

	public Puntosventa() {
	}

	public int getIdpuntosVenta() {
		return this.idpuntosVenta;
	}

	public void setIdpuntosVenta(int idpuntosVenta) {
		this.idpuntosVenta = idpuntosVenta;
	}

	public String getCelularcomercial() {
		return this.celularcomercial;
	}

	public void setCelularcomercial(String celularcomercial) {
		this.celularcomercial = celularcomercial;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
		return "Puntosventa [idpuntosVenta=" + idpuntosVenta + ", celularcomercial=" + celularcomercial + ", createdAt="
				+ createdAt + ", descripcion=" + descripcion + ", direccion=" + direccion + ", estado=" + estado
				+ ", updatedAt=" + updatedAt + ", computadoras=" + computadoras + "]";
	}

	

}