package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Puntosventa;
import pe.edu.cibertec.webapp.repository.PuntosventaRepository;

@Component(value="puntosventaView")
@ViewScoped
public class PuntosventaView implements Serializable {

	private static final long serialVersionUID = -5371794607614396672L;
	
	@Inject
	private  PuntosventaRepository puntosventaRepository;
	
	private List<Puntosventa> puntosventas;
	
	private Puntosventa puntosventa;
	
	@PostConstruct
	public void init() {
		puntosventas=puntosventaRepository.findAll();
		puntosventa= new Puntosventa();
	}

		
	public List<Puntosventa> getPuntosventas() {
		return puntosventas;
	}


	public Puntosventa getPuntosventa() {
		return puntosventa;
	}



	public void registrar() {
		boolean exits= puntosventaRepository.existsById(puntosventa.getIdpuntosVenta());
		puntosventaRepository.save(puntosventa);
		if (exits) {
			addMessage("Hecho", "Se ha actualizado  satisfactoriamente");
		} else {
			addMessage("Hecho", "Se ha registrado  satisfactoriamente");
		}
		init();
	}
	
	public void eliminar(Puntosventa pun) {
		puntosventaRepository.delete(pun);
		addMessage("Hecho", "Se ha eliminado  correctamente");
		init();
	}
	public void buscar(int id) {
		puntosventa=puntosventaRepository.findById(id).get();
	}
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


}
