package com.projekat.Katalog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KatalogRepository extends CrudRepository<Katalog, Long> {

  //List<Katalog> findByKorisnikId(long korisnikId); --ovo malo nema smisla

  Katalog findById(long id);
}