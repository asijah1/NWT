package com.projekat.Ponuda;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ponude", path = "ponuda")
public interface PonudaRestRepository extends PagingAndSortingRepository<Ponuda, Long> {

  List<Ponuda> findByPonuda(@Param("ponuda") String name);
  
  Ponuda findById(@Param("id") String name);

}