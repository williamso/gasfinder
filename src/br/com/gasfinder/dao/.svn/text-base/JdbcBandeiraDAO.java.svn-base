package br.com.gasfinder.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.Bandeira;

public class JdbcBandeiraDAO extends JdbcDaoSupport {

	public int getMax(){
		String sql  = "SELECT max(id_bandeira) FROM bandeira";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public int salvar(Bandeira bandeira){
		String sql  = "INSERT INTO bandeira VALUES(?,?)";
		int retorno = this.getJdbcTemplate().update(sql, bandeira.getId(), bandeira.getNome());
		return retorno;
	}
	
	public int remover(long id){
		String sql  = "DELETE FROM bandeira WHERE id_bandeira = ?";
		int retorno = this.getJdbcTemplate().update(sql,id);
		return retorno;
	}
	
	public int altualizar(Bandeira bandeira){
		String sql  = "UPDATE bandeira SET bandeira = ? WHERE id_bandeira = ?";
		int retorno = this.getJdbcTemplate().update(sql, bandeira.getNome(), bandeira.getId());
		return retorno;
	}
	

}
