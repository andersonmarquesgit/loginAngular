package br.com.loginAngular.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import br.com.loginAngular.security.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("br.com.loginAngular.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger log = Logger.getLogger(SecurityConfig.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    private AuthenticationSuccessHandler restAuthenticationSuccessHandler;
	
	@Autowired
    private AuthenticationFailureHandler restAuthenticationFailureHandler;
	   
	public SecurityConfig() {
		log.info("::::Inicializa��o do Security Config::::");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/views/**", "/resources/**", "/index.html", "/login.html");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.headers().disable()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.and()
			.formLogin()
                .loginProcessingUrl("/authenticate")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .usernameParameter("username")
                .passwordParameter("password") 
                .permitAll()
                .and()
			.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and();
	}
	
}
