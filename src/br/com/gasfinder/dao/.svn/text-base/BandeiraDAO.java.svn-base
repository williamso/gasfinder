package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Bandeira;


public class BandeiraDAO extends HibernateDaoSupport {
	
	public List<Bandeira> buscarTodos(){
		return getHibernateTemplate().loadAll(Bandeira.class);
	}
	
	public Bandeira buscarPorId(Long id){
		return getHibernateTemplate().get(Bandeira.class, id);		
	}
	
	public void gravar(Bandeira bandeira){
		getHibernateTemplate().saveOrUpdate(bandeira);
	}
	
	public void excluir(Bandeira bandeira){
		getHibernateTemplate().delete(bandeira);
	}
	
}
