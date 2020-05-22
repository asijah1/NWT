package com.example.systemevents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface AkcijaRepository extends JpaRepository<Akcija, Long> {
		
}
