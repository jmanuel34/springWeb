package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;
@Service("cursosService")
public class CursosServiceImpl implements CursosService{
	//para que el arraylist no se pierda y todas las intancias
	//lo compartan
	static List<Curso>  cursos=new ArrayList<>(List.of(
					new Curso ("Aaa", 100, 30.5),
					new Curso ("Bbb", 150, 31.5),
					new Curso ("Ccc", 1200, 150)					
				));
	
	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	@Override
	public boolean nuevo(Curso curso) {		
		for(Curso c:cursos) {
			if(c.getNombre().equals(curso.getNombre())) {
				return false;
			}
		}
		cursos.add(curso);
		return true;		
	}
	
	@Override
	public ArrayList<Curso> preciosCursoMax(double precioMax){
		ArrayList<Curso> auxiliar=new ArrayList<>();
		for(Curso c:cursos) {
			if(c.getPrecio()<=precioMax) {
				auxiliar.add(c);
			}
		}
		return auxiliar;
	}
	
	@Override
	public void eliminarCurso(String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));		
	}
	
	@Override
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		for(Curso c:cursos) {
			if(c.getNombre().equals(nombre)) {
				c.setDuracion(nuevaDuracion);
				break;
			}
		}
	}
}
