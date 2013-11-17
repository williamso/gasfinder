package br.com.gasfinder.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gasfinder.dao.BandeiraDAO;
import br.com.gasfinder.dao.JdbcBandeiraDAO;
import br.com.gasfinder.entidade.Bandeira;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="bandeiraController")
@ViewScoped
public class BandeiraController {

	private BandeiraDAO bandeiraDAO = (BandeiraDAO) BeanFactory.getBean("bandeiraDAO", BandeiraDAO.class);
	private JdbcBandeiraDAO jdbcBandeiraDAO = (JdbcBandeiraDAO) BeanFactory.getBean("jdbcBandeiraDAO", JdbcBandeiraDAO.class);
	
	private List<Bandeira> bandeiras;
	
	private long id;
	
	private String bandeira;
	
	@PostConstruct
    public void init() {
		bandeiras = bandeiraDAO.buscarTodos();
    }

	public List<Bandeira> getBandeiras() {
		return bandeiras;
	}

	public void setBandeiras(List<Bandeira> bandeiras) {
		this.bandeiras = bandeiras;
	}
	
	
	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void salvar(){
		Bandeira b = new Bandeira();
		b.setId((long) this.jdbcBandeiraDAO.getMax()+1);
		b.setNome(bandeira);
		
    	if(this.jdbcBandeiraDAO.salvar(b) > 0){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bandeira criada com sucesso " + bandeira + "!"));
		} 
 	}
	
	public void atualizar(){
		Bandeira b = new Bandeira();
		b.setId(this.id);
		b.setNome(bandeira);
		
    	if(this.jdbcBandeiraDAO.altualizar(b) > 0){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bandeira atualizada com sucesso " + bandeira + "!"));
		} 
 	}
	
	public void remover(){
		if(this.jdbcBandeiraDAO.remover(this.id) > 0){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bandeira removida com sucesso " + bandeira + "!"));
		} 
 	}
	
}
