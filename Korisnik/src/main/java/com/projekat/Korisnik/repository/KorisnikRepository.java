package com.projekat.Korisnik.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.projekat.Korisnik.model.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {

  ArrayList<Korisnik> findByLastName(String lastName);
  ArrayList<Korisnik> findByFirstName(String firstName);
  Korisnik findById(long id);
  
}
