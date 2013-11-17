package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Estado;


public class EstadoDAO extends HibernateDaoSupport {
	
	public List<Estado> buscarTodos(){
		return getHibernateTemplate().loadAll(Estado.class);
	}
	
	public Estado buscarPorId(Long id){
		return getHibernateTemplate().get(Estado.class, id);		
	}
	
	public void gravar(Estado estado){
		getHibernateTemplate().saveOrUpdate(estado);
	}
	
	public void excluir(Estado estado){
		getHibernateTemplate().delete(estado);
	}
	
}
