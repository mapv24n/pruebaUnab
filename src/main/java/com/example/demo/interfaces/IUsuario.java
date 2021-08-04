package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuarios;

@Repository
public interface IUsuario extends JpaRepository<Usuarios, Integer> {

}
