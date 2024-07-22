package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Resultado;

@Repository
public interface ResultadosDao {
	List<Resultado> findByTematica(String tematica);
	void save (Resultado resultado);
	Resultado findByUrl(String url);
	void deleteByUrl(String url);
}
