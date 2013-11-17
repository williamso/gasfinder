package br.com.gasfinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.Posto;
import br.com.gasfinder.entidade.Usuario;
import br.com.gasfinder.entidade.ValorCombustivel2;

public class JdbcValorCombustivel2DAO extends JdbcDaoSupport {

	public int getMax(){
		String sql  = "SELECT max(id_valor) FROM valor_combustiveis_2";
	
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public int salvar(ValorCombustivel2 vc){
		String sql  = "INSERT INTO valor_combustiveis_2 VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		int retorno = this.getJdbcTemplate().update(sql, vc.getId(), vc.getPosto().getId(), vc.getDataAlteracao(), vc.getDataAlteracao(),
													vc.getUsuario().getId(), vc.getValorGasolina(), vc.getValorEtanol(),
													vc.getValorGNV(), vc.getValorGLP(),vc.getValorDiesel(), vc.getStatus());
		
		return retorno;
	}
	
	public int atualizar(ValorCombustivel2 vc){
		int retorno = this.atualizarParaHistorico(vc);
		if(retorno == 1){
			retorno = this.atualizarParaAprovado(vc);
		}
		return retorno;
	}
	
	public int atualizarParaHistorico(ValorCombustivel2 vc){
		String sql  = "UPDATE valor_combustiveis_2 SET status = 'H' WHERE id_posto = ? AND status = 'A'";
		int retorno = this.getJdbcTemplate().update(sql, vc.getPosto().getId());
		return retorno;
	}
	
	public int atualizarParaAprovado(ValorCombustivel2 vc){
		String sql  = "UPDATE valor_combustiveis_2 SET status = 'A' WHERE id_valor = ?";
		int retorno = this.getJdbcTemplate().update(sql, vc.getId());
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarTodos(){
		String sql  = "SELECT * FROM valor_combustiveis_2";
	
		return this.getJdbcTemplate().query(sql, new ValorCombustiveis2RowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorCombustivel2> buscarTodosAprovar(){
		String sql  = "SELECT * FROM valor_combustiveis_2 WHERE status = 'P'";
	
		return this.getJdbcTemplate().query(sql, new ValorCombustiveis2RowMapper());
	}
	
	@SuppressWarnings("rawtypes")
	private static final class ValorCombustiveis2RowMapper implements RowMapper {

	    public ValorCombustivel2 mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	ValorCombustivel2 vc = new ValorCombustivel2();
	    	
	    	vc.setId(rs.getLong("id_valor"));
	    	
	    	Posto p = new Posto();
	    	p.setId(rs.getLong("id_posto"));
	    	vc.setPosto(p);
	    	
	    	vc.setDataAlteracao(rs.getTimestamp("data_alteracao"));
	    	vc.setDataAlteracao(rs.getTimestamp("data_coleta"));
	    	
	    	Usuario u = new Usuario();
	    	u.setId(rs.getLong("id_user_alteracao"));
	    	vc.setUsuario(u);
	    	
	    	vc.setValorGasolina(rs.getBigDecimal("valor_gasolina"));
	    	vc.setValorEtanol(rs.getBigDecimal("valor_etanol"));
	    	vc.setValorGLP(rs.getBigDecimal("valor_glp"));
	    	vc.setValorGNV(rs.getBigDecimal("valor_gnv"));
	    	vc.setValorDiesel(rs.getBigDecimal("valor_diesel"));
	    	vc.setStatus(rs.getString("status"));
	        return vc;
	    }
	}
	

}
