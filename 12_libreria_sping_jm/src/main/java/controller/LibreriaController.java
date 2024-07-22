package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.ClienteDto;
import dtos.LibroDto;
import jakarta.servlet.http.HttpSession;
import service.ClientesService;
import service.LibrosService;

@Controller
public class LibreriaController {
	ClientesService clientesService;
	LibrosService librosService;
	
	public LibreriaController(ClientesService clientesService, LibrosService librosService) {
		this.clientesService = clientesService;
		this.librosService = librosService;
	}
	
	@PostMapping(value="login")
	public String autenticar(@RequestParam("usuario") String usuario,
					@RequestParam("password") String password) {
		if(clientesService.autenticar(usuario, password)) {
			return "inicio";
		}
		return "registro";
	}
	
	@PostMapping(value="altaCliente",produces=MediaType.TEXT_PLAIN_VALUE)
	public String  altaCliente (@ModelAttribute ClienteDto cliente) {
		if(clientesService.registrar(cliente)) {
			return "login";
		}
		return "login";	
	}
	
	@GetMapping(value="temas")
	public String temas(Model model) {
		model.addAttribute("temas", librosService.getTemas());
		return "visor";
	}
	
	@GetMapping(value="librosTema",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> librosTema(@RequestParam("idTema")int idTema){
		return librosService.librosTema(idTema);
	}
	
	@PostMapping(value="altaLibro",produces=MediaType.TEXT_PLAIN_VALUE)
	//el idTema lo recogemos a parte para después construir el TemaDto
	public @ResponseBody String altaLibro(@ModelAttribute LibroDto libro, @RequestParam("idTema")int idTema) {
		libro.setTemaDto(librosService.getTema(idTema));
		return String.valueOf(librosService.guardarLibro(libro));
	}
	
	@GetMapping(value="agregarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> agregarCarrito(@RequestParam("isbn") int isbn, HttpSession sesion) {
		
		LibroDto libro=librosService.getLibro(isbn);
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)sesion.getAttribute("carrito");
		}
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	
	@GetMapping(value="eliminarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LibroDto> eliminarCarrito(@RequestParam("pos") int pos, 
												HttpSession sesion) {
		List<LibroDto> carrito = new ArrayList<>();
 		if(sesion.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)sesion.getAttribute("carrito");
		}
		carrito.remove(librosService.getLibro(pos));
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	
	

}
