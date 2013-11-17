package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Posto;


public class PostoDAO extends HibernateDaoSupport {
	
	public List<Posto> buscarTodos(){
		return getHibernateTemplate().loadAll(Posto.class);
	}
	
	public Posto buscarPorId(Long id){
		return getHibernateTemplate().get(Posto.class, id);		
	}
	
	public void gravar(Posto posto){
		getHibernateTemplate().saveOrUpdate(posto);
	}
	
	public void excluir(Posto posto){
		getHibernateTemplate().delete(posto);
	}
	
}
