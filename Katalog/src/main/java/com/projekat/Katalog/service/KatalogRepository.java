package com.projekat.Katalog.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projekat.Katalog.model.Katalog;

public interface KatalogRepository extends CrudRepository<Katalog, Long> {

  //List<Katalog> findByKorisnikId(long korisnikId); --ovo malo nema smisla

  Katalog findById(long id);
}