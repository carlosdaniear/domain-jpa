package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Marca;
import pe.edu.cibertec.webapp.repository.MarcaRepository;

@Component(value="marcaView")
@ViewScoped
public class MarcaView implements Serializable {
	
	private static final long serialVersionUID = 8049082699963619272L;
	
	 @Inject
	 private MarcaRepository marcarepository;
	 
	 private List<Marca> marcas;
	 
	 private Marca marca;
	 
	 @PostConstruct
	 public void init() {
		 marcas=marcarepository.findAll();
		 marca=new Marca();
	 }

	public List<Marca> getMarcas() {
		return marcas;
	}

	public Marca getMarca() {
		return marca;
	}
	public void registrar() {
		boolean exits= marcarepository.existsById(marca.getIdmarca());
		marcarepository.save(marca);
		if(exits) {
			addMessage("Sistem", "Se ha registrado satifactoriamente");
		}else {
			addMessage("sistema", "Se ha actualizado satisfactoriamente");
		}
		init();
	}
	
	public void eliminar(Marca mar) {
		marcarepository.delete(mar);
		addMessage("Sistema", "Se ha eliminado satifactoriamente");
		init();
	}
	
	public Marca buscar(Marca mar) {
		marca=marcarepository.findById(mar.getIdmarca()).get();
		return marca;
	}
	 
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
