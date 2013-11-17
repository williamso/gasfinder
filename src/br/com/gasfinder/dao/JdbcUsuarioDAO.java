package br.com.gasfinder.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.Usuario;

public class JdbcUsuarioDAO extends JdbcDaoSupport {

	public int getMax(){
		String sql  = "SELECT max(id_usuario) FROM usuarios";
	
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public int salvar(Usuario usuario){
		String sql  = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";
		int retorno = this.getJdbcTemplate().update(sql, usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getSocial(), usuario.getUsuario(), usuario.getAtivo());
		
		String sql2 = "INSERT INTO usuario_autorizacao VALUES(?,?)";
		retorno = this.getJdbcTemplate().update(sql2, usuario.getUsuario(), "ROLE_USER");
		
		return retorno;
	}
	

}
