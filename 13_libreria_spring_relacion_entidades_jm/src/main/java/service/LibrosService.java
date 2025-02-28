package service;

import java.util.List;

import entities.Tema;
import model.LibroDto;
import model.TemaDto;

public interface LibrosService {
	List<TemaDto> getTemas();

	List<LibroDto> librosTema(int idTema);

	LibroDto getLibro(int isbn);

	TemaDto getTema(int idTema);

	boolean guardarLibro(LibroDto libro);
	TemaDto findTemaByTitulo(String titulo);

}
