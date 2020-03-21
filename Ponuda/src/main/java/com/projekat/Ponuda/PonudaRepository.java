package com.projekat.Ponuda;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PonudaRepository extends CrudRepository<Ponuda, Long> {

  List<Ponuda> findByPonuda(Long ponuda); //ođe možda greška, provjerit

  Ponuda findById(long id);
}