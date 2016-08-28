package com.at.library.service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.UserDao;
import com.at.library.dto.UserDTO;
import com.at.library.dto.RentDTO;
import com.at.library.enums.UserEnum;
import com.at.library.model.User;
import com.at.library.service.rent.RentService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RentService rentService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<UserDTO> findAll() {
		final Iterable<User> findAll = userDao.findAll();
		final Iterator<User> iterator = findAll.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User u = iterator.next();
			final UserDTO uDTO = transform(u);
			res.add(uDTO);
		}
		return res;
	}

	@Override
	public UserDTO transform(User user) {
		return dozer.map(user, UserDTO.class);
	}

	@Override
	public User transform(UserDTO rent) {
		return dozer.map(rent, User.class);
	}
	
	@Override
	public List<UserDTO> transform(List<User> user) {	
		final Iterator<User> iterator = user.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User b = iterator.next();
			final UserDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public UserDTO create(UserDTO user) {
		User u = transform(user);
		u.setUserStatus(UserEnum.ALLOWED);
		return transform(userDao.save(u));
	}

	@Override
	public UserDTO getByIdDTO(Integer id) {
		User u = userDao.findOne(id);
		return transform(u);
	}
	
	@Override
	public User getById(Integer id){
		User u = userDao.findOne(id);
		return u;
	}

	@Override
	public void update(UserDTO user) {
		User u = transform(user);
		transform(userDao.save(u));
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<RentDTO> getRents(Integer id) {
		List<RentDTO> r = rentService.getByUserId(id);
		return r;
	}

	@Override
	public List<UserDTO> getByParams(String dni, String name, String surname1, String surname2, String address) {
		List<UserDTO> b = transform(userDao.findByDniOrNameOrSurname1OrSurname2OrAddress(dni,name,surname1,surname2,address));
		return b;
	}

}
