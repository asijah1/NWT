package com.projekat.Katalog.repository;

import com.projekat.Katalog.model.Katalog;

import org.springframework.data.repository.CrudRepository;


public interface KatalogRepository extends CrudRepository<Katalog, Long> {

  //List<Katalog> findById(long katalogId); --ovo malo nema smisla
  
  Katalog findById(long id);
  
  //public Katalog save(Katalog katalog);
}
