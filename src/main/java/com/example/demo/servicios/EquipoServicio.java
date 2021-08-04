package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IEquipo;
import com.example.demo.interfazservicios.IEquiposServicio;
import com.example.demo.modelo.Equipos;

@Service
public class EquipoServicio implements IEquiposServicio{

	@Autowired
	private IEquipo data;
	
	@Override
	public List<Equipos> listar() {
		return (List<Equipos>)data.findAll();
	}

}
