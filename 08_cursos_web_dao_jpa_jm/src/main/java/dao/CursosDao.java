package dao;

import java.util.List;

import entities.Curso;

public interface CursosDao {
	void save(Curso curso);
	List<Curso> findByPrecioMax(double precioMax);
	void deleteCurso(String nombre);
	List<Curso> findByName(String curso);
}
