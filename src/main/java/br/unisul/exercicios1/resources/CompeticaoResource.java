package br.unisul.exercicios1.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.exercicios1.domain.Competicao;
import br.unisul.exercicios1.services.CompeticaoService;

@RestController
@RequestMapping(value="/competicao")
public class CompeticaoResource {
	
	@Autowired
	private CompeticaoService service;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Competicao> find(@PathVariable Integer id){
		Competicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Competicao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Competicao obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	
	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Competicao>> findAll() {
		List<Competicao> lista = service.findAll();

		return ResponseEntity.ok().body(lista);
	}
}
