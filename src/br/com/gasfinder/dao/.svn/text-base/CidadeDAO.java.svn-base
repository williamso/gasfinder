package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Cidade;


public class CidadeDAO extends HibernateDaoSupport {
	
	public List<Cidade> buscarTodos(){
		return getHibernateTemplate().loadAll(Cidade.class);
	}
	
	public Cidade buscarPorId(Long id){
		return getHibernateTemplate().get(Cidade.class, id);		
	}
	
	public Cidade buscarPorDesc(String nome){
		return getHibernateTemplate().get(Cidade.class, nome);		
	}
	
	public void gravar(Cidade cidade){
		getHibernateTemplate().saveOrUpdate(cidade);
	}
	
	public void excluir(Cidade cidade){
		getHibernateTemplate().delete(cidade);
	}
	
}
