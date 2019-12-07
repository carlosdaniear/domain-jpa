package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE u.user = :usuario AND u.password = :password")
		Usuario login(@Param("usuario") String usuario, @Param("password") String password);
}
