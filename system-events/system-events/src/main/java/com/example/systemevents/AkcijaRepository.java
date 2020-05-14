package com.example.systemevents;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface AkcijaRepository extends CrudRepository<Akcija, Long> {
		
}
