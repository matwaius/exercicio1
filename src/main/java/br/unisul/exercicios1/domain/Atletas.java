package br.unisul.exercicios1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.unisul.exercicios1.domain.Competicao;

@Entity
public class Atletas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String modalidade;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ATLETA_COMPETICAO",
		joinColumns = @JoinColumn(name = "atleta_id"),
		inverseJoinColumns = @JoinColumn(name = "competicao_id")
	)
	private List<Competicao> competicao = new ArrayList<>();
	
	public Atletas()
	{
		
	}
	
	public Atletas(Integer id, String nome, String modalidade)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.modalidade = modalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public List<Competicao> getCompeticao() {
		return competicao;
	}

	public void setCompeticao(List<Competicao> competicao) {
		this.competicao = competicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atletas other = (Atletas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
