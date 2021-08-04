package com.example.demo.interfazservicios;

import java.util.List;

import com.example.demo.modelo.Usuarios;

public interface IUsuarioServicio {
	public List<Usuarios> listar();
	public int save(Usuarios u);
}
