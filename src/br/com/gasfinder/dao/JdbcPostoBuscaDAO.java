package br.com.gasfinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.PostoBusca;

public class JdbcPostoBuscaDAO extends JdbcDaoSupport {

	@SuppressWarnings("unchecked")
	public List<PostoBusca> buscarTodos(){
		String sql  = "SELECT * FROM v_busca_posto";
	
		return this.getJdbcTemplate().query(sql, new PostoBuscaRowMapper());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PostoBusca> buscarTodosAprovados(){
		String sql  = "SELECT * FROM v_busca_posto WHERE status = 'A'";
	
		return this.getJdbcTemplate().query(sql, new PostoBuscaRowMapper());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PostoBusca> buscarPorId(Long code){
		String sql  = "SELECT * FROM v_busca_posto WHERE code = "+code;
		return this.getJdbcTemplate().query(sql, new PostoBuscaRowMapper());		
	}
	
	@SuppressWarnings("unchecked")
	public List<PostoBusca> buscarPorIdAprovado(Long code){
		String sql  = "SELECT * FROM v_busca_posto WHERE code = "+code;
		return this.getJdbcTemplate().query(sql, new PostoBuscaRowMapper());		
	}
	
	@SuppressWarnings("rawtypes")
	private static final class PostoBuscaRowMapper implements RowMapper {

	    public PostoBusca mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	PostoBusca posto = new PostoBusca();
	    	posto.setCode(rs.getLong("code"));
	    	posto.setNomePosto(rs.getString("nomePosto"));
	    	posto.setEndereco(rs.getString("endereco"));
	    	posto.setBandeira(rs.getString("bandeira"));
	    	posto.setCidade(rs.getString("cidade"));
	    	posto.setUf(rs.getString("uf"));
	    	posto.setValorGasolina(rs.getBigDecimal("valorGasolina"));
	    	posto.setValorEtanol(rs.getBigDecimal("valorEtanol"));
	    	posto.setValorDiesel(rs.getBigDecimal("valorDiesel"));
	    	posto.setValorGNV(rs.getBigDecimal("valorGNV"));
	    	posto.setValorGLP(rs.getBigDecimal("valorGLP"));
	    	posto.setLatitude(rs.getDouble("latitude"));
	    	posto.setLongitude(rs.getDouble("longitude"));
	    	posto.setDataAtualizacao(rs.getDate("dataAtualizacao"));
	    	posto.setStatus(rs.getString("status"));
	        return posto;
	    }
	}
}
