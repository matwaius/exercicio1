package br.unisul.exercicios1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.exercicios1.domain.Atletas;
import br.unisul.exercicios1.repositories.AtletasRepository;

@Service
public class AtletaService {

	@Autowired
	private AtletasRepository atlRep;
	
	public Atletas find(Integer id) {
		Optional<Atletas> obj = atlRep.findById(id);
		return obj.orElse(null);
	}
	
	//LISTAR TODAS
	public List<Atletas> findAll(){
		return atlRep.findAll();
	}
}
