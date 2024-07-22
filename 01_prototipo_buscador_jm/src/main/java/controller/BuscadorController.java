package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Resultado;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired
	BuscadorService service;
	
	@GetMapping(value="buscar")
	public String buscarResultados(@RequestParam("tematica") String tematica, HttpServletRequest request) {
		List<Resultado> resultados= service.buscar(tematica);
		request.setAttribute("resultados", resultados);
		return "resultados";
	}
	
	@PostMapping(value="alta")
	public String altaResultado(@RequestParam("descripcion") String descripcion,
						@RequestParam("tematica") String tematica,
						@RequestParam("url") String url,
						HttpServletRequest request) {
		if (service.agregar(new Resultado(url, tematica, descripcion))){
			return "inicio";
		}
		return "error";
	}
	
	@GetMapping(value="toBuscarResultados")
	public String paginaBuscar() {
		return "buscarResultados";
	}
	
	@GetMapping(value="toAlta")
	public String paginaAlta() {
		return "alta";
	}
	
	@GetMapping(value={"toInicio","/"})
	public String paginaInicio() {
		return "inicio";
	}}
