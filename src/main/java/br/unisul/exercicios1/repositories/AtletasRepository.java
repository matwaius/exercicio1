package br.unisul.exercicios1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.exercicios1.domain.Atletas;

@Repository
public interface AtletasRepository extends JpaRepository<Atletas, Integer>{

}

