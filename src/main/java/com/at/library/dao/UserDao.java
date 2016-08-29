package com.at.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.at.library.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	@Query(value = "SELECT u from User as u where (dni like %:dni% OR :dni is null) AND (name like %:name% OR :name is null) AND "
			+ "(surname1 like %:surname1% OR :surname1 is null) AND (surname2 like %:surname2% OR :surname2 is null) AND"
			+ "(address like %:address% OR :address is null)")
	
	List<User> findByDniOrNameOrSurname1OrSurname2OrAddress(@Param(value="dni") String dni,@Param(value="name") String name, 
			@Param(value="surname1") String surname1,@Param(value="surname2") String surname2,@Param(value="address") String address);

	@Query(value="SELECT u from User as u where u.forgiveDate <= CURRENT_DATE")
	List<User> findPunished();
}
