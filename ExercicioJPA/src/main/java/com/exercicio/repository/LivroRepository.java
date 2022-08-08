package com.exercicio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercicio.entidades.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

}