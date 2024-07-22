package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.VentasDao;
import model.VentaDto;
import utilidades.Mapeador;

@Service
public class VentasServiceImpl implements VentasService {
	
	VentasDao ventasDao;
	Mapeador mapeador;
	
	public VentasServiceImpl(VentasDao ventasDao, Mapeador mapeador) {
		this.ventasDao = ventasDao;
		this.mapeador = mapeador;
	}

	@Override
	public List<VentaDto> ventasUsuario(String usuario) {
		return ventasDao.findByUsuario(usuario).stream()
					.map(v->mapeador.ventaEntityToDto(v))
					.toList();
	}

}
