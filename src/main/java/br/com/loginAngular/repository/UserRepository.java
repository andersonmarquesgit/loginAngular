package br.com.loginAngular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loginAngular.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	public User findByLoginAndPassword(String login, String password);
	public User findByLogin(String login);

} 