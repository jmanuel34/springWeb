package service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.BuscadorDao;
import entities.Resultado;
import model.ResultadoDto;
import utilidades.Mapeador;
@Service("buscadorEstandar")
@Scope("singleton")

public class BuscadorServiceImpl implements BuscadorService {
	BuscadorDao dao;
	Mapeador mapeador;
	public BuscadorServiceImpl(BuscadorDao dao, Mapeador mapeador) {
		this.dao = dao;
		this.mapeador=mapeador;
	}

	@Override
	public List<ResultadoDto> buscar(String tematica) {
		return dao.findByTematica(tematica).stream()
					.map(r->mapeador.resultadoEntityToDto(r))
					.toList();
	}

	@Override
	public boolean agregar(ResultadoDto resultado) {
		Resultado r=mapeador.resultadoDtoToEntity(resultado);
		if (dao.findByUrl(r.getUrl()) ==null) {
			dao.save(r);
			return true;
		}
		return false;
	}

	@Override
	public ResultadoDto buscarPorUrl(String url) {
		Resultado r = dao.findByUrl(url);
		return r!=null?mapeador.resultadoEntityToDto(r):null;
	}

	@Override
	public void eliminar(String url) {
		dao.deleteByUrl(url);
	}

}
