package dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, String>{
	
	@Query ("Select * from alumnos where alumno.cursos.idCurso=?")
	List<Alumno> alumnosPorCurso(int idCurso);
	
	@Query ("Select * from alumnos where alumno.cursos.fechaInicio > ?")
	List<Alumno> alumnosPorFechaCurso(LocalDate fecha);

}
