package service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import model.ResultadoDto;
@Service("buscadorEstandar")
@Scope("singleton")
public class BuscadorServiceImpl implements BuscadorService {
	BuscadorDao dao;
	
	
	public BuscadorServiceImpl(BuscadorDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ResultadoDto> buscar(String tematica) {
	}

	@Override
	public boolean agregar(ResultadoDto resultado) {
	}

	@Override
	public ResultadoDto buscarPorUrl(String url) {
	}

	@Override
	public void eliminar(String url) {
	}

}
