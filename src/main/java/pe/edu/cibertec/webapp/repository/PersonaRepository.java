package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
