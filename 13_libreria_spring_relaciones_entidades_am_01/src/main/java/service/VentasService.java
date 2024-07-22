package service;

import java.util.List;

import model.VentaDto;

public interface VentasService {
	List<VentaDto> ventasUsuario(String usuario);

}
