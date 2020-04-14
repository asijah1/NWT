package com.projekat.Ponuda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.projekat.Ponuda.model.Ponuda;

@RepositoryRestResource(collectionResourceRel = "ponude", path = "ponude")
public interface PonudaRepository extends CrudRepository<Ponuda, Long> {

  List<Ponuda> findByPonuda(Long ponuda); //ođe možda greška, provjerit
  List<Ponuda> findByIdKatalog(Long idKatalog);
  Ponuda findById(long id);
}