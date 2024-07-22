package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	void save(Curso curso);
	List<Curso> findByPrecio(double precio);
	void eliminar(String nombre);
	Curso findByName(String nombre);
	double averageByTematica(String tematica);
	
}
