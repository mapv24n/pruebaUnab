package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Equipos;

@Repository
public interface IEquipo extends JpaRepository<Equipos, Integer>{

}
