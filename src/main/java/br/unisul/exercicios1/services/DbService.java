package br.unisul.exercicios1.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.exercicios1.domain.Atletas;
import br.unisul.exercicios1.domain.Competicao;
import br.unisul.exercicios1.repositories.AtletasRepository;
import br.unisul.exercicios1.repositories.CompeticaoRepository;

@Service
public class DbService {
	
	@Autowired
	private AtletasRepository altRep;
	
	@Autowired
	private CompeticaoRepository comRep;	
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Atletas at1 = new Atletas(null, "Joao", "Salto");
		Atletas at2 = new Atletas(null, "Lucas", "Peso");
		Atletas at3 = new Atletas(null, "Habib", "Corrida");
		
		Competicao co1 = new Competicao(null, "1ª Comp Salto", "01/01/2012");
		Competicao co2 = new Competicao(null, "2ª Comp Salto", "01/01/2013");
		Competicao co3 = new Competicao(null, "20ª Comp Peso", "01/01/2011");
		Competicao co4 = new Competicao(null, "1ª Comp Corrida", "01/01/2010");
		Competicao co5 = new Competicao(null, "2ª Comp Corrida", "01/01/2015");
		
		at1.getCompeticao().addAll(Arrays.asList(co1,co2));
		at2.getCompeticao().addAll(Arrays.asList(co3));
		at3.getCompeticao().addAll(Arrays.asList(co5));
		
		comRep.saveAll(Arrays.asList(co1, co2, co3, co4, co5));
		altRep.saveAll(Arrays.asList(at1,at2,at3));


	}
	
}
