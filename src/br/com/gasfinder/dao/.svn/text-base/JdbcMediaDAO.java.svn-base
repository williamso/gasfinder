package br.com.gasfinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.gasfinder.entidade.CombustivelMedia;

public class JdbcMediaDAO extends JdbcDaoSupport{
	
	
	@SuppressWarnings("unchecked")
	public List<CombustivelMedia> getMedia(String cidade, String uf){
		
		String sql  = "  SELECT AVG(v.valor_gasolina),AVG(v.valor_etanol),AVG(v.valor_diesel),AVG(v.valor_gnv),AVG(v.valor_glp) " +
				      "    FROM v_posto_valor_combustivel v" +
				      "   WHERE v.cidade = ? AND  v.uf = ? AND v.status = 'A'";
		
		return this.getJdbcTemplate().query(sql, new String[]{cidade, uf}, new CombustivelMediaMapper());
	}

	@SuppressWarnings("rawtypes")
	private static final class CombustivelMediaMapper implements RowMapper {

	    public CombustivelMedia mapRow(ResultSet rs, int rowNum) throws SQLException {
	        CombustivelMedia media = new CombustivelMedia();
	        media.setValorGasolina(rs.getBigDecimal(1));
	        media.setValorEtanol(rs.getBigDecimal(2));
	        media.setValorDiesel(rs.getBigDecimal(3));
	        media.setValorGNV(rs.getBigDecimal(4));
	        media.setValorGLP(rs.getBigDecimal(5));
	        return media;
	    }
	}
}
