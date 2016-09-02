package com.at.library.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.at.library.model.Rent;

@Repository
public interface RentDao extends CrudRepository<Rent, Integer> {
	
	@Query(value="SELECT r from Rent as r where r.rentPK.book.id = ?1 AND r.endDate is null")
	public Rent checkReturnNull(Integer book_id);

	@Query(value="SELECT r from Rent as r where r.user.id = ?1")
	public List<Rent> findUserId(Integer id, Pageable pageable);

	@Query(value="SELECT r from Rent as r where r.rentPK.book.id = ?1")
	public List<Rent> findBookId(Integer id, Pageable pageable);

	@Query(value="SELECT r from Rent as r where r.returnDate < CURRENT_DATE"
			+ " and r.statusPunish = com.at.library.enums.RentPunishEnum.NOT_PUNISHED")
	public List<Rent> delayed();
	
}
