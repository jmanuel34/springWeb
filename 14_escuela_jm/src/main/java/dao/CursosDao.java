package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	
//	@Query("select c from Curso c where c.idCurso=?1")
	List<Curso> findByIdCurso(int idCurso);

	@Query("select c from Curso c where c.alumnos.usuario=?1")
	List<Curso> findByNombreAlumno(String usuario);
	
	@Query("select c from Curso c where c.alumnos.usuario not in ?1")
	List<Curso> cursosLibresPorNombreAlumno(String nombre);
	
//	Select c.idCurso, c.nombre, c.duracion, c.fechaInicio, c.precio from cursos c 
//		where c.idCurso NOT IN
//			(Select idCurso from matriculas where usuario = 
//				(select usuario from alumnos a where a.usuario = ?));
// fsdf
}
