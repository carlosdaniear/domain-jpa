package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.webapp.entity.Persona;
import pe.edu.cibertec.webapp.repository.PersonaRepository;;

@Component(value="personaView")
@ViewScoped
public class PersonaView  implements Serializable{

	private static final long serialVersionUID = -5684362261115927845L;
	
	@Inject
	private PersonaRepository personaRepository;

	private List<Persona> personas;
	
	private Persona persona;
	
	@PostConstruct
	public void init() {
		personas=personaRepository.findAll();
		persona= new Persona();
	}
	public List<Persona> getPersonas() {
		return personas;
	}

	public Persona getPersona() {
		return persona;
	}
	public void registrar() {
		boolean exits = personaRepository.existsById(persona.getIdpersona());
		personaRepository.save(persona);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}

	public void eliminar(Persona per) {
		personaRepository.delete(per);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		persona = personaRepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

}
