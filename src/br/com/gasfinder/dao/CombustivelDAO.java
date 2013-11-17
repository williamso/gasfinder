package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Combustivel;


public class CombustivelDAO extends HibernateDaoSupport {
	
	public List<Combustivel> buscarTodos(){
		return getHibernateTemplate().loadAll(Combustivel.class);
	}
	
	public Combustivel buscarPorId(Long id){
		return getHibernateTemplate().get(Combustivel.class, id);		
	}
	
	public void gravar(Combustivel combustivel){
		getHibernateTemplate().saveOrUpdate(combustivel);
	}
	
	public void excluir(Combustivel combustivel){
		getHibernateTemplate().delete(combustivel);
	}
	
}
