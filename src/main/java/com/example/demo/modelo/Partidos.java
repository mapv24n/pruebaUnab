package com.example.demo.modelo;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "partidos")
public class Partidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="usuario")
	private Usuarios usuario;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="local")
	private Equipos local;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="visitante")
	private Equipos visitante;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "goles_local")
	private int goles_local;
	@Column(name = "goles_visitante")
	private int goles_visitante;

	
	
	public Partidos() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Equipos getLocal() {
		return local;
	}

	public void setLocal(Equipos local) {
		this.local = local;
	}

	public Equipos getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipos visitante) {
		this.visitante = visitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getGoles_local() {
		return goles_local;
	}

	public void setGoles_local(int goles_local) {
		this.goles_local = goles_local;
	}

	public int getGoles_visitante() {
		return goles_visitante;
	}

	public void setGoles_visitante(int goles_visitante) {
		this.goles_visitante = goles_visitante;
	}

	@Override
	public String toString() {
		return "Partidos [id=" + id + ", usuario=" + usuario + ", local=" + local + ", visitante=" + visitante
				+ ", fecha=" + fecha + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + "]";
	}
	
	
	
}
