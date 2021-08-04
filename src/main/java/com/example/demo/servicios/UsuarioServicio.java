package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IUsuario;
import com.example.demo.interfazservicios.IUsuarioServicio;
import com.example.demo.modelo.Usuarios;

@Service
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
	private IUsuario data;
	
	@Override
	public List<Usuarios> listar() {
		// TODO Auto-generated method stub
		return (List<Usuarios>)data.findAll();
	}


	@Override
	public int save(Usuarios u) {
		int res =0;
		Usuarios usuario=data.save(u); 
		if(!usuario.equals(null)) {
			res=1;
		}
		return res;
	}

}
