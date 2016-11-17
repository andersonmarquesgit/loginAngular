package br.com.loginAngular.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.loginAngular.model.Role;
import br.com.loginAngular.model.User;
import br.com.loginAngular.repository.UserRepository;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserRepository userRepository;

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Role role) throws ServletException, IOException {
		User user = userRepository.findByLogin(role.getName());
//		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, user);
	} 

}
