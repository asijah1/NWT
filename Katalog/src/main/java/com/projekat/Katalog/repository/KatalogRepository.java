package com.projekat.Katalog.repository;

import com.projekat.Katalog.model.Katalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface KatalogRepository extends CrudRepository<Katalog, Long> {

  //List<Katalog> findById(long katalogId); --ovo malo nema smisla
  
  Katalog findById(long id);
  
  public Katalog save(Katalog katalog);
}
