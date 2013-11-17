package br.com.gasfinder.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gasfinder.dao.CidadeDAO;
import br.com.gasfinder.dao.EstadoDAO;
import br.com.gasfinder.entidade.Cidade;
import br.com.gasfinder.entidade.Estado;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="cidadeController")
@ViewScoped
public class CidadeController {

	private CidadeDAO cidadeDAO = (CidadeDAO) BeanFactory.getBean("cidadeDAO", CidadeDAO.class);
	private EstadoDAO estadoDAO = (EstadoDAO) BeanFactory.getBean("estadoDAO", EstadoDAO.class);
	
	private List<Cidade> cidades;
	
	private List<String> estados;
	
	private List<Estado> ufs;
	
	private String uf;
	
	@PostConstruct
    public void init() {
		cidades = cidadeDAO.buscarTodos();
		estados = new ArrayList<String>();
		ufs = estadoDAO.buscarTodos();
		for(Estado uf:ufs){
			estados.add(uf.getUf());
		}
    }

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Estado> getUfs() {
		return ufs;
	}

	public void setUfs(List<Estado> ufs) {
		this.ufs = ufs;
	}

	
	
	
}
