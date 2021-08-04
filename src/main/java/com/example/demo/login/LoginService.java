package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuarios;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Usuarios login(String username, String password) {
		Usuarios user = repo.findByUsernameAndPassword(username, password);
		return user;
	}

}