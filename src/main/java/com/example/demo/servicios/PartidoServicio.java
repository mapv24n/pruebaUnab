package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IPartido;
import com.example.demo.interfazservicios.IPartidoServicio;
import com.example.demo.modelo.Partidos;

@Service
public class PartidoServicio implements IPartidoServicio {

	@Autowired
	private IPartido data;
	
	@Override
	public List<Partidos> listarPartidos() {
		// TODO Auto-generated method stub
		return (List<Partidos>)data.findAll();
	}
	
	@Override
	public Optional<Partidos> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Partidos u) {
		int res =0;
		Partidos partido=data.save(u); 
		if(!partido.equals(null)) {
			res=1;
		}
		return res;
	}

}
