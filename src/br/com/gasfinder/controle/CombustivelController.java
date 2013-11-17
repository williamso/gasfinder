package br.com.gasfinder.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gasfinder.dao.CombustivelDAO;
import br.com.gasfinder.entidade.Combustivel;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="combustivelController")
@ViewScoped
public class CombustivelController {

	private CombustivelDAO combustivelDAO = (CombustivelDAO) BeanFactory.getBean("combustivelDAO", CombustivelDAO.class);
	
	private List<Combustivel> combustiveis;
	
	
	@PostConstruct
    public void init() {
		combustiveis = combustivelDAO.buscarTodos();
    }


	public List<Combustivel> getCombustiveis() {
		return combustiveis;
	}


	public void setCombustiveis(List<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	
	
}
