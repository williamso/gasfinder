package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.ValorCombustivel2;


public class ValorCombustivel2DAO extends HibernateDaoSupport {
	
	public List<ValorCombustivel2> buscarTodos(){
		return getHibernateTemplate().loadAll(ValorCombustivel2.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarTodosAprovar(){
		return getHibernateTemplate().find("from ValorCombustivel2 where status = 'P'");
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarPorFiltros(Long id){
		return getHibernateTemplate().find("from ValorCombustivel2 where id_posto = ?", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarPorFiltroAprovados(Long id){
		return getHibernateTemplate().find("from ValorCombustivel2 where id_posto = ? and status = 'A'", id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarPorFiltroHistoricos(Long id){
		return getHibernateTemplate().find("from ValorCombustivel2 where id_posto = ? and (status = 'H' OR status = 'A')", id);	
	}
	
	public ValorCombustivel2 buscarPorId(Long id){
		return getHibernateTemplate().get(ValorCombustivel2.class, id);		
	}
	
	public void gravar(ValorCombustivel2 valor){
		getHibernateTemplate().save(valor);
	}
	
	public void excluir(ValorCombustivel2 valor){
		getHibernateTemplate().delete(valor);
	}
	
}
