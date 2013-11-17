package br.com.gasfinder.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uf", unique=true, nullable=false)
	private Long id;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="nome")
	private String nome;

	public Estado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
