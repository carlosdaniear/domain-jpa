package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the computadora database table.
 * 
 */
@Entity
@NamedQuery(name="Computadora.findAll", query="SELECT c FROM Computadora c")
public class Computadora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private String createdAt;

	private String estado;

	private String precio;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to Carreraprofesional
	@ManyToOne
	@JoinColumn(name="idcarrera")
	private Carreraprofesional carreraprofesional;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;

	//bi-directional many-to-one association to Puntosventa
	@ManyToOne
	@JoinColumn(name="idpuntosventa")
	private Puntosventa puntosventa;

	//bi-directional many-to-one association to Detallecompu
	@OneToMany(mappedBy="computadora")
	private List<Detallecompu> detallecompus;

	public Computadora() {
		this.carreraprofesional=new Carreraprofesional();
		this.categoria=new Categoria();
		this.marca= new Marca();
		this.puntosventa= new Puntosventa();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Carreraprofesional getCarreraprofesional() {
		return this.carreraprofesional;
	}

	public void setCarreraprofesional(Carreraprofesional carreraprofesional) {
		this.carreraprofesional = carreraprofesional;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Puntosventa getPuntosventa() {
		return this.puntosventa;
	}

	public void setPuntosventa(Puntosventa puntosventa) {
		this.puntosventa = puntosventa;
	}

	public List<Detallecompu> getDetallecompus() {
		return this.detallecompus;
	}

	public void setDetallecompus(List<Detallecompu> detallecompus) {
		this.detallecompus = detallecompus;
	}

	@Override
	public String toString() {
		return "Computadora [id=" + id + ", createdAt=" + createdAt + ", estado=" + estado + ", precio=" + precio
				+ ", updatedAt=" + updatedAt + ", marca=" + marca + "]";
	}
	
}