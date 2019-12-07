package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Carreraprofesional;
import pe.edu.cibertec.webapp.entity.Categoria;
import pe.edu.cibertec.webapp.entity.Computadora;
import pe.edu.cibertec.webapp.entity.Detallecompu;
import pe.edu.cibertec.webapp.entity.Marca;
import pe.edu.cibertec.webapp.entity.Ordenador;
import pe.edu.cibertec.webapp.entity.Puntosventa;
import pe.edu.cibertec.webapp.repository.CarreraRepository;
import pe.edu.cibertec.webapp.repository.CategoriaResponsitory;
import pe.edu.cibertec.webapp.repository.ComputadoraRepository;
import pe.edu.cibertec.webapp.repository.DetalleComputadoraRepository;
import pe.edu.cibertec.webapp.repository.MarcaRepository;
import pe.edu.cibertec.webapp.repository.OrdenadorRepository;
import pe.edu.cibertec.webapp.repository.PuntosventaRepository;

@Component(value="computadoraView")
@ViewScoped
public class ComputadoraView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ComputadoraRepository computadoraRepository;
	@Inject
	private  CarreraRepository carreraRepository;
	@Inject
	private MarcaRepository marcaRepository;
	@Inject
	private PuntosventaRepository puntosventaRepository;
	@Inject
	private CategoriaResponsitory categoriaResponsitory;
	@Inject
	private DetalleComputadoraRepository detalleComputadoraRepository;
	@Inject
	private OrdenadorRepository ordenadorRepository;
	
	
	private  List<Computadora> computadoras;
	
	private Computadora computadora;
	private Detallecompu detallecompu;
	private Ordenador  ordenador;
	@PostConstruct
	public void init() {
		computadoras=computadoraRepository.findAll();
		computadora= new Computadora();
		detallecompu = new Detallecompu();
		ordenador= new Ordenador();
	}

	
	public ComputadoraRepository getComputadoraRepository() {
		return computadoraRepository;
	}


	public CarreraRepository getCarreraRepository() {
		return carreraRepository;
	}


	public MarcaRepository getMarcaRepository() {
		return marcaRepository;
	}


	public PuntosventaRepository getPuntosventaRepository() {
		return puntosventaRepository;
	}


	public CategoriaResponsitory getCategoriaResponsitory() {
		return categoriaResponsitory;
	}
	

	public OrdenadorRepository getOrdenadorRepository() {
		return ordenadorRepository;
	}


	public DetalleComputadoraRepository getDetalleComputadoraRepository() {
		return detalleComputadoraRepository;
	}


	public List<Computadora> getComputadoras() {
		return computadoras;
	}


	public Computadora getComputadora() {
		return computadora;
	}
	

	public Detallecompu getDetallecompu() {
		return detallecompu;
	}


	public Ordenador getOrdenador() {
		return ordenador;
	}


	public void registrar() {
		boolean exits= computadoraRepository.existsById(computadora.getId());
		Carreraprofesional car = carreraRepository.findById(computadora.getCarreraprofesional().getIdcarreraprofe()).get();
		computadora.setCarreraprofesional(car);
		

		
		Marca mar = marcaRepository.findById(computadora.getMarca().getIdmarca()).get();
		computadora.setMarca(mar);
		
		Categoria cat = categoriaResponsitory.findById(computadora.getCategoria().getId()).get();
		computadora.setCategoria(cat);
		
		Puntosventa pun = puntosventaRepository.findById(computadora.getPuntosventa().getIdpuntosVenta()).get();
		computadora.setPuntosventa(pun);
		computadoraRepository.save(computadora);
		Computadora compu =computadoraRepository.findById(computadora.getId()).get();
		detallecompu.setComputadora(compu);
		detalleComputadoraRepository.save(detallecompu);
		ordenador.setPrecio(computadora.getPrecio());
		ordenador.setCategoria(computadora.getCategoria().getDescripcion());
		ordenador.setMarca(computadora.getMarca().getDescripcion());
		ordenadorRepository.save(ordenador);
		if (exits) {
			addMessage("Hecho", "Se ha actualizado  satisfactoriamente");
		} else {
			addMessage("Hecho", "Se ha registrado  satisfactoriamente");
		}
		
		init();
	}
	
	public void eliminar(Computadora com) {
		computadoraRepository.delete(com);
		addMessage("Hecho", "Se ha eliminado  correctamente");
		init();
	}
	public void buscar(int id) {
		computadora=computadoraRepository.findById(id).get();
		detallecompu=detalleComputadoraRepository.query(id);
	}
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

}
