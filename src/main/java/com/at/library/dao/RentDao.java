package com.at.library.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.at.library.model.Rent;

@Repository
public interface RentDao extends CrudRepository<Rent, Integer> {
	
	@Query(value="SELECT r from Rent as r where r.rentPK.book.id = ?1 AND r.returnDate is null")
	public Rent checkReturnNull(Integer book_id);
	
}
