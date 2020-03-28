package com.projekat.Korisnik.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projekat.Korisnik.model.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {

  List<Korisnik> findByLastName(String lastName);

  Korisnik findById(long id);
}