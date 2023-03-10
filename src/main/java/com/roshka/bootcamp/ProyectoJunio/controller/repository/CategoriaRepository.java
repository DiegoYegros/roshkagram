package com.roshka.bootcamp.ProyectoJunio.controller.repository;

import com.roshka.bootcamp.ProyectoJunio.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
