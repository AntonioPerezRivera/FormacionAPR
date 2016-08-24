package com.at.library.service.room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.RoomDao;
import com.at.library.dto.RoomDTO;
import com.at.library.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<RoomDTO> findAll() {
		final Iterable<Room> findAll = roomDao.findAll();
		final Iterator<Room> iterator = findAll.iterator();
		final List<RoomDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Room u = iterator.next();
			final RoomDTO uDTO = transform(u);
			res.add(uDTO);
		}
		return res;
	}

	@Override
	public RoomDTO transform(Room room) {
		return dozer.map(room, RoomDTO.class);
	}

	@Override
	public Room transform(RoomDTO rent) {
		return dozer.map(rent, Room.class);
	}

	@Override
	public RoomDTO create(RoomDTO room) {
		Room r = transform(room);
		return transform(roomDao.save(r));
	}

	@Override
	public RoomDTO getById(Integer id) {
		Room r = roomDao.findOne(id);
		return transform(r);
	}

	@Override
	public void update(RoomDTO room) {
		Room r = transform(room);
		transform(roomDao.save(r));
	}

	@Override
	public void delete(Integer id) {
		roomDao.delete(id);
	}

}
