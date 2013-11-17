package br.com.gasfinder.entidade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name="v_busca_posto")
public class PostoBusca {
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="code")
	private Long code;
	
	@Id
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="nomePosto")
	private String nomePosto;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="endereco")
	private String  endereco;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="bandeira")
	private String  bandeira;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="cidade")
	private String  cidade;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="uf")
	private String  uf;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="valorGasolina")
	private BigDecimal valorGasolina;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="valorEtanol")
	private BigDecimal valorEtanol;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="valorDiesel")
	private BigDecimal valorDiesel;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="valorGNV")
	private BigDecimal valorGNV;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="valorGLP")
	private BigDecimal valorGLP;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="latitude")
	private Double  latitude;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="longitude")
	private Double longitude;
	
	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="dataAtualizacao")
	private Date dataAtualizacao;

	@Field(index=Index.TOKENIZED,store=Store.YES)
	@Column(name="status")
	private String status;

	public String getNomePosto() {
		return nomePosto==null?"":nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public String getEndereco() {
		return endereco==null?"":endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBandeira() {
		return bandeira==null?"":bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getCidade() {
		return cidade==null?"":cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf==null?"":uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public BigDecimal getValorGasolina() {
		return this.casasDecimais(2, valorGasolina);   
	}

	public void setValorGasolina(BigDecimal valorGasolina) {
		this.valorGasolina = valorGasolina;
	}

	public BigDecimal getValorEtanol() {
		return this.casasDecimais(2, valorEtanol);  
	}

	public void setValorEtanol(BigDecimal valorEtanol) {
		this.valorEtanol = valorEtanol;
	}

	public BigDecimal getValorDiesel() {
		return this.casasDecimais(2, valorDiesel); 
	}

	public void setValorDiesel(BigDecimal valorDiesel) {
		this.valorDiesel = valorDiesel;
	}

	public BigDecimal getValorGNV() {
		return this.casasDecimais(2, valorGNV);
	}

	public void setValorGNV(BigDecimal valorGNV) {
		this.valorGNV = valorGNV;
	}

	public BigDecimal getValorGLP() {
		return this.casasDecimais(2, valorGLP);
	}

	public void setValorGLP(BigDecimal valorGLP) {
		this.valorGLP = valorGLP;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao==null?new Date():dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private BigDecimal casasDecimais(int casas, BigDecimal valor)  
	{  
	    String quantCasas = "%."+casas+"f", textoValor = "0";  
	    try  
	    {  
	        textoValor = String.format(Locale.getDefault(), quantCasas, valor);  
	    }catch(java.lang.IllegalArgumentException e)  
	    {  
	        // Quando os digitos com 2 casas decimais forem Zeros, exemplo: 0.000001233888.  
	        // Nao existe valor 0,00 , logo entra na java.lang.IllegalArgumentException.  
	        if(e.getMessage().equals("Digits < 0"))  
	            textoValor = "0";  
	        System.out.println(e.getMessage());  
	    }  
	    return new BigDecimal(textoValor.replace(",", "."));  
	}  
}
