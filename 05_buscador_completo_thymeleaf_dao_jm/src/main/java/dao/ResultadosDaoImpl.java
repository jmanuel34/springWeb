package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Resultado;

@Repository

public class ResultadosDaoImpl implements ResultadosDao {
	@Autowired
	JdbcTemplate template;
	@Override
	public List<Resultado> findByTematica(String tematica) {
		String sql = "Select * from resultados where tematica = ?";
		RowMapper<Resultado> mapper = (r,f)->new Resultado(
											r.getString("url"),
											r.getString("tematica"),
											r.getString("descripcion")
										);
		return template.query(sql, mapper, tematica);
	}

	@Override
	public void save(Resultado resultado) {
		template.update("Insert into resultados (url, tematica, descripcion) values(?,?,?)",
																resultado.getUrl(),
																resultado.getTematica(),
																resultado.getDescripcion()
			);
	}

	@Override
	public Resultado findByUrl(String url) {
	
		String sql = "Select * from resultados where url = ?";
		RowMapper<Resultado> mapper = (r,f)->new Resultado(
											r.getString("url"),
											r.getString("tematica"),
											r.getString("descripcion")
										);
		List<Resultado> resultados = template.query(sql,  mapper, url);
		return resultados.size()>0? resultados.get(0):null;
	}
	
	@Transactional
	@Override
	public void deleteByUrl(String url) {
		template.update("Delete from resultados r where r.url=?1");
		Query query =AbstractCacheManager.createQuery(jpql);
		
		
	}

}
