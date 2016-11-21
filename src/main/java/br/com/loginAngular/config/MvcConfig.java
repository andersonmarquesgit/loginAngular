package br.com.loginAngular.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.loginAngular.controller")
public class MvcConfig {

	private static final Logger log = Logger.getLogger(MvcConfig.class);
	
	public MvcConfig() {
		log.info("::::Inicialização do MVC Config e Escaneamento dos Controladores::::");
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
}
