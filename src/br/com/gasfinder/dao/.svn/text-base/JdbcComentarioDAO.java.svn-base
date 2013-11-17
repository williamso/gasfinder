package br.com.gasfinder.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.Comentario;

public class JdbcComentarioDAO extends JdbcDaoSupport {

	public int getMax(){
		String sql  = "SELECT max(id_comentario) FROM comentarios";
	
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public int salvar(Comentario c){
		String sql  = "INSERT INTO comentarios VALUES(?,?,?,?,?,?)";
		int retorno = this.getJdbcTemplate().update(sql, c.getId(), c.getUsuario().getId(), c.getPosto().getId(), c.getComentario(), c.getData(), c.getStatus());
		
		return retorno;
	}
	
	public int atualizar(Comentario c){
		String sql  = "UPDATE comentarios SET status = ? WHERE id_comentario = ?";
		int retorno = this.getJdbcTemplate().update(sql, c.getStatus(), c.getId());
		return retorno;
	}
	

}
