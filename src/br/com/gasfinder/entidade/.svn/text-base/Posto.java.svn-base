package br.com.gasfinder.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="postos")
public class Posto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_posto", unique=true, nullable=false)
	private Long id;
	
	@Column(name="razao_social")
	private String nome;
	
	@Column(name="endereco")
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name="cidade", referencedColumnName = "id_cidade")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name="bandeira", referencedColumnName = "id_bandeira")
	private Bandeira bandeira;
	
	@Column(name="cep")
	private String cep;
	

	public Posto() {
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


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public Bandeira getBandeira() {
		return bandeira;
	}


	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
