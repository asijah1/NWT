package com.projekat.Ponuda.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projekat.Ponuda.model.Ponuda;

public interface PonudaRepository extends CrudRepository<Ponuda, Long> {

  List<Ponuda> findByPonuda(Long ponuda); //ođe možda greška, provjerit

  Ponuda findById(long id);
}