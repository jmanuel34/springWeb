package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Curso;
import service.CursosService;

@Controller
public class CursosController {
	@Autowired
	CursosService service;

	@PostMapping(value="alta")
	public String altaResultado(@ModelAttribute Curso curso) {
		return service.nuevo(curso)?"inicio":"error";
	}
	
	@GetMapping(value="buscar")
	public String buscarResultados(@RequestParam("precio") Double precio, HttpServletRequest request) {
		List<Curso> resultados = service.preciosCursoMax(precio);
		request.setAttribute("resultados", resultados);
		return "resultados";
	}
	
	@PostMapping(value="eliminar")
	public String eliminarResultado(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "inicio";
	}
	
	@GetMapping(value= "formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo";
	}
	
	
	
}
