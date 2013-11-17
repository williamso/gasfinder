package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Comentario;


public class ComentarioDAO extends HibernateDaoSupport {
	
	public List<Comentario> buscarTodos(){
		return getHibernateTemplate().loadAll(Comentario.class);
	}
	
	public Comentario buscarPorId(Long id){
		return getHibernateTemplate().get(Comentario.class, id);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> buscarPorFiltro(Long id){
		return getHibernateTemplate().find("from Comentario where id_posto = ?", id);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> buscarPorFiltroAprovador(Long id){
		return getHibernateTemplate().find("from Comentario where id_posto = ? and status = 'A'", id);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> buscarPorFiltroAprovar(){
		return getHibernateTemplate().find("from Comentario where status = 'P'");		
	}
	
	public void gravar(Comentario comentario){
		getHibernateTemplate().saveOrUpdate(comentario);
	}
	
	public void excluir(Comentario comentario){
		getHibernateTemplate().delete(comentario);
	}
	
}
