package com.example.demo.interfazservicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Partidos;


public interface IPartidoServicio {
	public List<Partidos> listarPartidos(); 
	public Optional<Partidos>listarId(int id);
	public int save(Partidos u);
}
