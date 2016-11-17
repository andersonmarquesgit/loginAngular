package br.com.loginAngular.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.loginAngular.config.MvcConfig;
import br.com.loginAngular.config.RepositoryConfig;
import br.com.loginAngular.config.SecurityConfig;
import br.com.loginAngular.config.ServiceConfig;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
//		return new Class[]{SecurityConfig.class, ServiceConfig.class, RepositoryConfig.class};
		return new Class[] {SecurityConfig.class, RepositoryConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
