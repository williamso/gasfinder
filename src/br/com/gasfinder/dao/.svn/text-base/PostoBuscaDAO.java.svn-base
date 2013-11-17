package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.PostoBusca;

public class PostoBuscaDAO extends HibernateDaoSupport {

	public List<PostoBusca> buscarTodos(){
		return getHibernateTemplate().loadAll(PostoBusca.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<PostoBusca> buscarPorId(Long code){
		return getHibernateTemplate().find("from PostoBusca  where code = ?", code);		
	}
}
