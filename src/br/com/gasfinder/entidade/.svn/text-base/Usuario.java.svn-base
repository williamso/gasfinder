package br.com.gasfinder.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario", unique=true, nullable=false)
	private Long id;
	
	@Column(name="username")
	private String usuario;
	
	@Column(name="password")
	private String senha;

	@Column(name="email")
	private String email;
	
	@Column(name="enable", columnDefinition = "BOOLEAN")
	private boolean ativo;
	
	@Column(name="conta_social")
	private String social;
	
	@OneToMany
    private List<Autorizacao> autorizacoes;
	
	 public Usuario() {
	 }

	 public Usuario(String usuario, String senha, boolean ativo, List<Autorizacao> autorizacoes) {
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
        this.autorizacoes = autorizacoes;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

}	
