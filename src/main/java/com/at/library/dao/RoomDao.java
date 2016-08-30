package com.at.library.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.at.library.model.Room;

@Repository
public interface RoomDao extends CrudRepository<Room, Integer> {

	@Query(value="SELECT r from Room where r.name = :nameRoom")
	Room getByName(@Param(value="nameRoom")String nameRoom);

}
