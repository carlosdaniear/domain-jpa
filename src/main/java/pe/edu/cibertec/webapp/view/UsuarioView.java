package pe.edu.cibertec.webapp.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Persona;
import pe.edu.cibertec.webapp.entity.Usuario;
import pe.edu.cibertec.webapp.repository.PersonaRepository;
import pe.edu.cibertec.webapp.repository.UsuarioRepository;

@Component(value="userView")
@ViewScoped
public class UsuarioView {
	
	@Inject
	private UsuarioRepository usuariorepository;
	
	@Inject
	private PersonaRepository personaRepository;
	
	private String nombre;
	@NotEmpty(message="Ingrese su numbre de usuario")
	private String usuario;
	@NotEmpty(message="Ingrese su contraseña")
	private String password;
	
	private List<Usuario> usuarios;
	
	private Usuario user;
	
	
	@PostConstruct
	public void init() {
		usuarios=usuariorepository.findAll();
		user= new Usuario();
		
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUser() {
		return user;
	}
	
	
	
	public void registrar() {
		boolean exits = usuariorepository.existsById(user.getIduser());
		Persona per = personaRepository.findById(user.getPersona().getIdpersona()).get();
		user.setPersona(per);
		usuariorepository.save(user);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}
	
	
	
	public void eliminar(Usuario usu) {
		usuariorepository.delete(usu);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		user = usuariorepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		Usuario usu=  usuariorepository.login(usuario, password);
		if (usu != null) {
			return "dashboard";
		}else {
			FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usurio y/o conraseña incorretos",null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "login";
		}
		
	}
}
