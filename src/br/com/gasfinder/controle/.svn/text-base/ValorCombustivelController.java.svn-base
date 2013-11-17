package br.com.gasfinder.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gasfinder.dao.JdbcValorCombustivel2DAO;
import br.com.gasfinder.dao.ValorCombustivel2DAO;
import br.com.gasfinder.entidade.ValorCombustivel2;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="valorCombustivelController")
@ViewScoped
public class ValorCombustivelController {

	private ValorCombustivel2DAO valorCombustivel2DAO = (ValorCombustivel2DAO) BeanFactory.getBean("valorCombustivel2DAO", ValorCombustivel2DAO.class);
	
	private JdbcValorCombustivel2DAO jdbcValorCombustivel2DAO = (JdbcValorCombustivel2DAO) BeanFactory.getBean("jdbcValorCombustivel2DAO", JdbcValorCombustivel2DAO.class);
	
	private List<ValorCombustivel2> vcs;
	
	private ValorCombustivel2 valor;
	
	@PostConstruct
    public void init() {
		vcs = jdbcValorCombustivel2DAO.buscarTodosAprovar();
    }

	public void aprovar(){
		valor.setStatus("A");
		
		if(this.jdbcValorCombustivel2DAO.atualizar(valor) == 1){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor Aprovado Com Sucesso!"));  
    	}
	}

	public void reprovar(){
		try {
			this.valorCombustivel2DAO.excluir(valor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor Reprovado Com Sucesso!")); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<ValorCombustivel2> getVcs() {
		return vcs;
	}

	public void setVcs(List<ValorCombustivel2> vcs) {
		this.vcs = vcs;
	}

	public ValorCombustivel2 getValor() {
		return valor;
	}

	public void setValor(ValorCombustivel2 valor) {
		this.valor = valor;
	}

	
}
