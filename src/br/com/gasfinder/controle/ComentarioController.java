package br.com.gasfinder.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gasfinder.dao.ComentarioDAO;
import br.com.gasfinder.dao.JdbcComentarioDAO;
import br.com.gasfinder.entidade.Comentario;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="comentarioController")
@ViewScoped
public class ComentarioController {

	private ComentarioDAO comentarioDAO = (ComentarioDAO) BeanFactory.getBean("comentarioDAO", ComentarioDAO.class);
	
	private JdbcComentarioDAO jdbcComentarioDAO = (JdbcComentarioDAO) BeanFactory.getBean("jdbcComentarioDAO", JdbcComentarioDAO.class);
	
	private List<Comentario> comentarios;
	
	private Comentario comentario;
	
	@PostConstruct
    public void init() {
		comentarios = comentarioDAO.buscarPorFiltroAprovar();
    }
	
	public void aprovar(){
		comentario.setStatus("A");
		
		if(this.jdbcComentarioDAO.atualizar(comentario) == 1){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comentario Aprovado Com Sucesso!"));  
    	}
	}

	public void reprovar(){
		try {
			this.comentarioDAO.excluir(comentario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comentario Reprovado Com Sucesso!")); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	

	
}
