package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmarca;

	private String descripcion;

	//bi-directional many-to-one association to Computadora
	@OneToMany(mappedBy="marca")
	private List<Computadora> computadoras;

	public Marca() {
	}

	public int getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Computadora> getComputadoras() {
		return this.computadoras;
	}

	public void setComputadoras(List<Computadora> computadoras) {
		this.computadoras = computadoras;
	}

	@Override
	public String toString() {
		return "Marca [idmarca=" + idmarca + ", descripcion=" + descripcion + "]";
	}
	

	//public Computadora addComputadora(Computadora computadora) {
	//	getComputadoras().add(computadora);
	//	computadora.setMarca(this);

	//	return computadora;
	//}

	//public Computadora removeComputadora(Computadora computadora) {
	//	getComputadoras().remove(computadora);
	//	computadora.setMarca(null);

	//	return computadora;
	//}


	

}