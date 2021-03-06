package br.unisul.exercicios1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.exercicios1.domain.Atletas;
import br.unisul.exercicios1.domain.Competicao;
import br.unisul.exercicios1.services.AtletaService;

@RestController
@RequestMapping(value = "/atletas")
public class AtletasResource {

	@Autowired
	private AtletaService service;
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atletas> find(@PathVariable Integer id)
	{
		Atletas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Atletas>> findAll() {
		List<Atletas> lista = service.findAll();

		return ResponseEntity.ok().body(lista);
	}
}
