package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import controller.config.MvcConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import service.config.ModelConfig;

public class InitConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Registra la clase de configuración del modelo
				AnnotationConfigWebApplicationContext rootContext =new AnnotationConfigWebApplicationContext();
				rootContext.register(ModelConfig.class);
				// Registra la clase de configuración del controlador
				AnnotationConfigWebApplicationContext dispatcherContext =new AnnotationConfigWebApplicationContext();
				dispatcherContext.register(MvcConfig.class);
				// Gestiona el ciclo de vida del contexto de aplicación
				servletContext.addListener(new ContextLoaderListener(rootContext));
				// Crea y    r_e_g_i_s_t_r_a   el DispatcherServlet
				ServletRegistration.Dynamic dispatcher =
						servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
				dispatcher.setLoadOnStartup(1);
				dispatcher.addMapping("/");
	}

}
