package com.at.library.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.at.library.model.Zone;

@Repository
public interface ZoneDao extends CrudRepository<Zone, Integer> {

	@Query(value="SELECT z from Zone as z where z.name = :name")
	Zone getByName(@Param(value="name") String name);

}
