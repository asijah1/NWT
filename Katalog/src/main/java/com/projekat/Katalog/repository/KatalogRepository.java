package com.projekat.Katalog.repository;

import com.projekat.Katalog.model.Katalog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "katalozi", path = "katalozi")
public interface KatalogRepository extends CrudRepository<Katalog, Long> {

  //List<Katalog> findById(long katalogId); --ovo malo nema smisla
  
  Katalog findById(long id);

List<Katalog> findByNazivProizvoda(String nazivProizvoda);

  
  //public Katalog save(Katalog katalog);
}
