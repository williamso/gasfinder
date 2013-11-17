package br.com.gasfinder.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.gasfinder.entidade.Usuario;


public class UsuarioDAO extends HibernateDaoSupport {
	
	public List<Usuario> buscarTodos(){
		return getHibernateTemplate().loadAll(Usuario.class);
	}
	
	public Usuario buscarPorId(Long id){
		return getHibernateTemplate().get(Usuario.class, id);		
	}
	
	public void gravar(Usuario usuario){
		getHibernateTemplate().save(usuario);
	}
	
	public void excluir(Usuario usuario){
		getHibernateTemplate().delete(usuario);
	}
	
	@SuppressWarnings("rawtypes")
	public int getMax(){
		@SuppressWarnings("unused")
		List max = getHibernateTemplate().find("select max(u.id_usuario) from Usuario u");
		
		return 1;
	}
	
}
