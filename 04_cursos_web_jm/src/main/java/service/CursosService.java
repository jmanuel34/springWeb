package service;

import java.util.ArrayList;

import model.Curso;

public interface CursosService {

	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	boolean nuevo(Curso curso);

	ArrayList<Curso> preciosCursoMax(double precioMax);

	void eliminarCurso(String nombre);

	void modificarDuracion(String nombre, int nuevaDuracion);

}