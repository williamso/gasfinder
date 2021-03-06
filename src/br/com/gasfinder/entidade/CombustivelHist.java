package br.com.gasfinder.entidade;

import java.math.BigDecimal;
import java.util.Date;

public class CombustivelHist {
	
	private Long code;
	
	private String  combustivel;
	
	private BigDecimal valor;
	
	private Date dataAtualizacao;


	public String getCombustivel() {
		return combustivel==null?"":combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public BigDecimal getValor() {
		return (BigDecimal) (valor==null?new BigDecimal(0):valor);
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao==null?new Date():dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
}
