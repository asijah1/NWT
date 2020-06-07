package com.projekat.Korisnik.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.projekat.Korisnik.model.Korisnik;

@RepositoryRestResource(collectionResourceRel = "korisnici", path = "korisnici")
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

  ArrayList<Korisnik> findByLastName(String lastName);
  ArrayList<Korisnik> findByFirstName(String firstName);
  Korisnik findByEmail(String email);
  Korisnik findById(long id);
  
}
