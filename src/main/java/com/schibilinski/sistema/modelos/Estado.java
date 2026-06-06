package com.schibilinski.sistema.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id //indica que o campo id é a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.AUTO)// indica que o valor do campo id será gerado automaticamente pelo banco de dados
	
	
	private Long id;
	private String nome;
	private String sigla;

	public Estado() {
	}

	public Estado(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
