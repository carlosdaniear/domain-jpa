package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Detallecompu;

@Repository
public interface DetalleComputadoraRepository extends JpaRepository<Detallecompu, Integer> {
	@Query("SELECT u FROM Detallecompu u WHERE u.computadora.id = :id")
	Detallecompu query(@Param("id") int id);
}
