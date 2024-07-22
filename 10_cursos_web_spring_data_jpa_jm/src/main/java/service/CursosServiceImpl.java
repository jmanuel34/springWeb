package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.CursosDao;
import entities.Curso;
import model.CursoDto;
import utilidades.Mapeador;
@Service
public class CursosServiceImpl implements CursosService{
	CursosDao dao;
	Mapeador mapeador;

	
	public CursosServiceImpl(CursosDao cursosDao, Mapeador mapeador) {
		this.dao = cursosDao;
		this.mapeador=mapeador;
	}
	
	@Override
	public boolean nuevo(CursoDto curso) {		
		Curso c = mapeador.DtoToEntity(curso);
		if (dao.findByNombre(c.getNombre()).size() == 0) {
			dao.save(c);
			return true;
		}
		return false;
	}
	
	@Override
	public List<CursoDto> preciosCursoMax(double precioMax){		
		return dao.findByPrecioMax(precioMax).stream()
				.map(c->mapeador.EntityToDto(c))
				.toList();	
	}
	
	@Override
	public void eliminarCurso(String nombre) {
		dao.deleteByNombre(nombre);
	}
	
	
}
