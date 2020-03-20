package com.projekat.Korisnik;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {

  List<Korisnik> findByLastName(String lastName);

  Korisnik findById(long id);
}