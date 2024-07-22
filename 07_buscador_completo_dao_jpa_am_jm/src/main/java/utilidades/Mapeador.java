package utilidades;

import org.springframework.stereotype.Component;

import entities.Resultado;
import model.ResultadoDto;
@Component
public class Mapeador {
	
	public Resultado resultadoEntityToDto(Resultado resultado) {
//	return new Resultado(0,"a","b","c");	
		return new Resultado(0, resultado.getUrl(), resultado.getTematica(), resultado.getDescripcion());
	}
	
	public ResultadoDto resultadoDtoToEntity(ResultadoDto dto) {
		return new ResultadoDto(dto.getUrl(), dto.getTematica(), dto.getDescripcion());
	}
}
