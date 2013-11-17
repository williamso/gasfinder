package br.com.gasfinder.entidade;

import java.math.BigDecimal;
import java.util.Date;

public class CombustivelHistModel {
	
	private Long code;
	
	private BigDecimal valorGasolina;
	
	private BigDecimal valorEtanol;
	
	private BigDecimal valorGNV;
	
	private BigDecimal valorDiesel;
	
	private Date dataAtualizacao;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
