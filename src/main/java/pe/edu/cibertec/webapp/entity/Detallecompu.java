package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallecompu database table.
 * 
 */
@Entity
@NamedQuery(name="Detallecompu.findAll", query="SELECT d FROM Detallecompu d")
public class Detallecompu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddetallecompu;

	private String discoduro;

	private String fuentepoder;

	private String memoriaram;

	private String placamadre;

	private String procesador;

	//bi-directional many-to-one association to Computadora
	@ManyToOne
	@JoinColumn(name="idcomputadora")
	private Computadora computadora;

	public Detallecompu() {
		this.computadora= new Computadora();
	}

	public int getIddetallecompu() {
		return this.iddetallecompu;
	}

	public void setIddetallecompu(int iddetallecompu) {
		this.iddetallecompu = iddetallecompu;
	}

	public String getDiscoduro() {
		return this.discoduro;
	}

	public void setDiscoduro(String discoduro) {
		this.discoduro = discoduro;
	}

	public String getFuentepoder() {
		return this.fuentepoder;
	}

	public void setFuentepoder(String fuentepoder) {
		this.fuentepoder = fuentepoder;
	}

	public String getMemoriaram() {
		return this.memoriaram;
	}

	public void setMemoriaram(String memoriaram) {
		this.memoriaram = memoriaram;
	}

	public String getPlacamadre() {
		return this.placamadre;
	}

	public void setPlacamadre(String placamadre) {
		this.placamadre = placamadre;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public Computadora getComputadora() {
		return this.computadora;
	}

	public void setComputadora(Computadora computadora) {
		this.computadora = computadora;
	}

	@Override
	public String toString() {
		return "Detallecompu [iddetallecompu=" + iddetallecompu + ", discoduro=" + discoduro + ", fuentepoder="
				+ fuentepoder + ", memoriaram=" + memoriaram + ", placamadre=" + placamadre + ", procesador="
				+ procesador + ", computadora=" + computadora + "]";
	}

}