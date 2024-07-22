package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDao;
import model.Curso;
@Service
public class CursosServiceImpl implements CursosService{
	
//	@Autowired
	CursosDao dao;
	
	public CursosServiceImpl(CursosDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean nuevo(Curso curso) {	
/*
		List<Curso> cursos = dao.findByName(curso.getNombre());
		Curso aux =cursos.stream()
				.findFirst()
				.orElse(null);
		
		if (aux==null) {
			dao.save(curso);
			return true;
		}
		return false;	
//*/
		if(dao.findByName(curso.getNombre()) ==null) {
			dao.save(curso);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Curso> preciosCursoMax(double precioMax){		
		return dao.findByPrecio(precioMax);
	}
	
	@Override
	public void eliminarCurso(String nombre) {		
		 dao.eliminar(nombre);	
	}
	
	
}
