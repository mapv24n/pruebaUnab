package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Partidos;

@Repository
public interface IPartido extends JpaRepository<Partidos, Integer>{

}
