package br.com.gasfinder.controle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.gasfinder.dao.JdbcMediaDAO;
import br.com.gasfinder.entidade.CombustivelMedia;
import br.com.gasfinder.util.BeanFactory;




@ManagedBean(name="indexController")
@ViewScoped
public class IndexController {

	private JdbcMediaDAO mediaDAO = (JdbcMediaDAO) BeanFactory.getBean("mediaDAO", JdbcMediaDAO.class);
	private String cidade;
	private String uf;
	private BigDecimal gasolina;
	private BigDecimal alcool;
	private BigDecimal dieesil;
	private BigDecimal gas;
	
	
	public IndexController(){
		this.cidade = "";
		this.uf = "";
	}

	/**
	 * Grava novo registro ou atualiza um registro
	 */
	public void media(ActionEvent actionEvent){
		this.cidade = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cidade"); 
		this.uf = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("uf"); 
		
	    List<CombustivelMedia> preco = this.mediaDAO.getMedia(this.cidade, this.uf);
	    
	    for(CombustivelMedia cm:preco){
    		this.gasolina = this.casasDecimais(2,cm.getValorGasolina());
    		this.alcool = this.casasDecimais(2,cm.getValorEtanol());
    		this.dieesil = this.casasDecimais(2,cm.getValorDiesel());
    		this.gas = this.casasDecimais(2,cm.getValorGNV());
	    }
	    
		System.out.println("Cidade: "+this.cidade+"  "+"UF: "+this.uf);
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
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public BigDecimal getGasolina() {
		return gasolina;
	}

	public void setGasolina(BigDecimal gasolina) {
		this.gasolina = gasolina;
	}

	public BigDecimal getAlcool() {
		return alcool;
	}

	public void setAlcool(BigDecimal alcool) {
		this.alcool = alcool;
	}

	public BigDecimal getDieesil() {
		return dieesil;
	}

	public void setDieesil(BigDecimal dieesil) {
		this.dieesil = dieesil;
	}

	public BigDecimal getGas() {
		return gas;
	}

	public void setGas(BigDecimal gas) {
		this.gas = gas;
	}
	
}
