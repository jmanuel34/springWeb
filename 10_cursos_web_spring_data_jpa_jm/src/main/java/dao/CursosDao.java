package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	@Query("Select c from Curso c Where c.precio<=?1")
	List<Curso> findByPrecioMax(double precioMax);
	
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
	List<Curso> findByNombre(String nombre);
	
}
