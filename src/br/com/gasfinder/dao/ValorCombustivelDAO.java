package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.ValorCombustivel;


public class ValorCombustivelDAO extends HibernateDaoSupport {
	
	public List<ValorCombustivel> buscarTodos(){
		return getHibernateTemplate().loadAll(ValorCombustivel.class);
	}
	
	public ValorCombustivel buscarPorId(Long id){
		return getHibernateTemplate().get(ValorCombustivel.class, id);		
	}
	
	public void gravar(ValorCombustivel valor){
		getHibernateTemplate().saveOrUpdate(valor);
	}
	
	public void excluir(ValorCombustivel valor){
		getHibernateTemplate().delete(valor);
	}
	
}
