package br.unisul.exercicios1.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.exercicios1.domain.Competicao;
import br.unisul.exercicios1.repositories.CompeticaoRepository;
@Service
public class CompeticaoService {

	@Autowired
	private CompeticaoRepository comRep;
	
	//BUSCAR POR ID
	public Competicao find (Integer id) {
		Optional<Competicao> obj = comRep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Competicao insert (Competicao obj) {
		obj.setId(null);
		return comRep.save(obj);
	}

	//ATUALIZAR
	public Competicao update (Competicao obj) {
		find(obj.getId());
		return comRep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		comRep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Competicao> findAll(){
		return comRep.findAll();
	}

}
