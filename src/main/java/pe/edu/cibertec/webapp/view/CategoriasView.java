package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Categoria;
import pe.edu.cibertec.webapp.repository.CategoriaResponsitory;

@Component(value="categoriaView")
@ViewScoped
public class CategoriasView  implements Serializable{

	private static final long serialVersionUID = -5684362261115927845L;
	
	@Inject
	private CategoriaResponsitory categoriaRepository;

	private List<Categoria> categorias;
	
	private Categoria categoria;
	
	@PostConstruct
	public void init() {
		categorias=categoriaRepository.findAll();
		categoria= new Categoria();
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void registrar() {
		boolean exits = categoriaRepository.existsById(categoria.getId());
		categoriaRepository.save(categoria);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}

	public void eliminar(Categoria cat) {
		categoriaRepository.delete(cat);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		categoria = categoriaRepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

}
