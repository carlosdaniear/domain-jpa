package pe.edu.cibertec.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Ordenador;

@Repository
public interface OrdenadorRepository extends JpaRepository<Ordenador, Integer> {
	@Query("SELECT u FROM Ordenador u WHERE u.marca = :marca")
	List<Ordenador> query(@Param("marca") String marca);
}
