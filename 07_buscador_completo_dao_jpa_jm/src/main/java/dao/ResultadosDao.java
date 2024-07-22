package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Resultado;

@Repository
public interface ResultadosDao {
	List<ResultadoDao> findByTematica(String tematica);
	void save (ResultadoDao resultado);
	Resultado findByUrl(String url);
	void deleteByUrl(String url);
}
