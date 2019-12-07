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
import pe.edu.cibertec.webapp.repository.CarreraRepository;

@Component(value="carreraView")
@ViewScoped
public class CarreraView implements Serializable {

	private static final long serialVersionUID = -5371794607614396672L;
	
	@Inject
	private  CarreraRepository carreraRepository;
	
	private List<Carreraprofesional> carreraprofesionales;
	
	private Carreraprofesional carreraprofesional;
	
	@PostConstruct
	public void init() {
		 carreraprofesionales=carreraRepository.findAll();
		 carreraprofesional= new Carreraprofesional();
	}

	public List<Carreraprofesional> getCarreraprofesionales() {
		return carreraprofesionales;
	}

	public Carreraprofesional getCarreraprofesional() {
		return carreraprofesional;
	}
	
	public void registrar() {
		boolean exits= carreraRepository.existsById(carreraprofesional.getIdcarreraprofe());
		carreraRepository.save(carreraprofesional);
		if (exits) {
			addMessage("Hecho", "Se ha actualizado  satisfactoriamente");
		} else {
			addMessage("Hecho", "Se ha registrado  satisfactoriamente");
		}
		init();
	}
	
	public void eliminar(Carreraprofesional carre) {
		carreraRepository.delete(carre);
		addMessage("Hecho", "Se ha eliminado  correctamente");
		init();
	}
	public void buscar(int id) {
		carreraprofesional=carreraRepository.findById(id).get();
	}
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


}
