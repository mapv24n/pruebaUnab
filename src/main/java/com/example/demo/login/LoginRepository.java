package com.example.demo.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuarios;

@Repository
public interface LoginRepository extends JpaRepository<Usuarios, Long>{
	Usuarios findByUsernameAndPassword(String username, String password);
 
}