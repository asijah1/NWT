package com.projekat.Katalog;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "katalog", path = "katalog")
public interface KatalogRestRepository extends PagingAndSortingRepository<Katalog, Long> {

  Katalog findById(long id); 

}