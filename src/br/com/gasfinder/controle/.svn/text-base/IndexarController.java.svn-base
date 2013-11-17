package br.com.gasfinder.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import br.com.gasfinder.entidade.PostoBusca;
import br.com.gasfinder.util.BeanFactory;

@ManagedBean(name="indexarController")
@ViewScoped
public class IndexarController {
	
	//PostoBuscaDAO postoBuscaDAO = (PostoBuscaDAO) BeanFactory.getBean("postoBuscaDAO", PostoBuscaDAO.class);
	
	private String status;
	
	public IndexarController(){}
	
	
	@SuppressWarnings("unchecked")
	public boolean indexar(){
		try {
			Session session = BeanFactory.getSessionFactory().openSession();
			//PostoBuscaDAO postoBuscaDAO = (PostoBuscaDAO) session.get("postoBuscaDAO", PostoBuscaDAO.class);
			
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			Transaction tx = fullTextSession.beginTransaction();
			//Object postoBusca = fullTextSession.load( PostoBusca.class, 8 );
			List<PostoBusca> lista = session.createQuery("from PostoBusca as v_posto_busca").list();//postoBuscaDAO.buscarTodos();
			
			int count = 1;
			for(PostoBusca postoBusca:lista){
				fullTextSession.index(postoBusca);
				System.out.println(count++ +" Indexando: "+postoBusca.getNomePosto());
			}
			
			tx.commit(); //index only updated at commit time
			session.close(); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
}
