package br.unisul.exercicios1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.exercicios1.domain.Competicao;
@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Integer> {

}
