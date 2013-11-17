package br.com.gasfinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.CombustivelHist;

public class JdbcCombustivelHistDAO extends JdbcDaoSupport {

	@SuppressWarnings("unchecked")
	public List<CombustivelHist> buscarTodos(){
		String sql  = "SELECT * FROM v_valor_combustivel_hist";
	
		return this.getJdbcTemplate().query(sql, new CombustivelHistRowMapper());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CombustivelHist> buscarPorId(Long code){
		String sql  = "SELECT * FROM v_valor_combustivel_hist WHERE code = "+code;
		return this.getJdbcTemplate().query(sql, new CombustivelHistRowMapper());		
	}
	
	@SuppressWarnings("rawtypes")
	private static final class CombustivelHistRowMapper implements RowMapper {

	    public CombustivelHist mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	CombustivelHist hist = new CombustivelHist();
	    	hist.setCode(rs.getLong("code"));
	    	hist.setDataAtualizacao(rs.getDate("dataAtualizacao"));
	    	hist.setCombustivel(rs.getString("combustivel"));
	    	hist.setValor(rs.getBigDecimal("valor"));
	        return hist;
	    }
	}
}
