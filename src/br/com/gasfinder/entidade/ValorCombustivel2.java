package br.com.gasfinder.entidade;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valor_combustiveis_2")
public class ValorCombustivel2 {

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
	private Timestamp dataAlteracao;
	
	@Column(name="data_coleta")
	private Timestamp dataColeta;
	
	@ManyToOne
	@JoinColumn(name="id_user_alteracao", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	@Column(name="valor_gasolina")
	private BigDecimal valorGasolina;

	@Column(name="valor_etanol")
	private BigDecimal valorEtanol;
	
	@Column(name="valor_glp")
	private BigDecimal valorGLP;
	
	@Column(name="valor_gnv")
	private BigDecimal valorGNV;
	
	@Column(name="valor_diesel")
	private BigDecimal valorDiesel;
	
	@Column(name="status")
	private String status;

	public ValorCombustivel2() {
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

	public Timestamp getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Timestamp dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Timestamp getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Timestamp dataColeta) {
		this.dataColeta = dataColeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorGasolina() {
		return valorGasolina;
	}

	public void setValorGasolina(BigDecimal valorGasolina) {
		this.valorGasolina = valorGasolina;
	}

	public BigDecimal getValorEtanol() {
		return valorEtanol;
	}

	public void setValorEtanol(BigDecimal valorEtanol) {
		this.valorEtanol = valorEtanol;
	}

	public BigDecimal getValorGLP() {
		return valorGLP;
	}

	public void setValorGLP(BigDecimal valorGLP) {
		this.valorGLP = valorGLP;
	}

	public BigDecimal getValorGNV() {
		return valorGNV;
	}

	public void setValorGNV(BigDecimal valorGNV) {
		this.valorGNV = valorGNV;
	}

	public BigDecimal getValorDiesel() {
		return valorDiesel;
	}

	public void setValorDiesel(BigDecimal valorDiesel) {
		this.valorDiesel = valorDiesel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
