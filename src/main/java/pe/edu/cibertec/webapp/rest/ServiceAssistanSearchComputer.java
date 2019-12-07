package pe.edu.cibertec.webapp.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.edu.cibertec.webapp.entity.Computadora;
import pe.edu.cibertec.webapp.entity.Marca;
import pe.edu.cibertec.webapp.entity.Ordenador;
import pe.edu.cibertec.webapp.repository.ComputadoraRepository;
import pe.edu.cibertec.webapp.repository.MarcaRepository;
import pe.edu.cibertec.webapp.repository.OrdenadorRepository;

@RestController
public class ServiceAssistanSearchComputer {
	
	@Inject
	private  OrdenadorRepository computadoraRepository;
	
	
	@GetMapping("/computadora")
	public List<Ordenador> findAll(){
		return computadoraRepository.findAll();
	}
	@RequestMapping(value = "/searchcomputer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> webhook(@RequestBody String jsonString)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonString);

		String marca = node.get("documento").asText();

		Map<String, List<Ordenador>> response = new HashMap<>();

		response.put("rsp", computadoraRepository.query(marca));
		return ResponseEntity.accepted().body(response);
	}

}
