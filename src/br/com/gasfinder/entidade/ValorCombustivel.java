package br.com.gasfinder.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valor_combustiveis")
public class ValorCombustivel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_valor", unique=true, nullable=false)
	private Long id;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_posto", referencedColumnName = "id_posto")
	private Posto posto;
	
	@Id
	@Column(name="data_alteracao")
	private Date dataAlteracao;
	
	@Column(name="data_coleta")
	private Date dataColeta;
	
	@ManyToOne
	@JoinColumn(name="id_user_alteracao", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="combustivel", referencedColumnName = "id_combustivel")
	private Combustivel combustivel;
	
	@Column(name="valor_combustivel")
	private Double valor;
	
	public ValorCombustivel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
