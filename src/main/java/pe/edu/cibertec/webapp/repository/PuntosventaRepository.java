package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Puntosventa;

@Repository
public interface PuntosventaRepository extends JpaRepository<Puntosventa, Integer> {

}
