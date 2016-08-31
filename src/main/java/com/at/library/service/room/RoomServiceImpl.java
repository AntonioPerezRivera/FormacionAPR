package com.at.library.service.room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.RoomDao;
import com.at.library.dto.RoomDTO;
import com.at.library.dto.RoomPostDTO;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.RoomNotFoundException;
import com.at.library.exception.ZoneNotFoundException;
import com.at.library.model.Room;
import com.at.library.model.Zone;
import com.at.library.service.zone.ZoneService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	private ZoneService zoneService;

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
	public RoomDTO create(RoomPostDTO room) throws RoomNotFoundException, ZoneNotFoundException {
		if(room == null){
			throw new RoomNotFoundException();
		}
		else{
			Room r = new Room();
			List<String> idZonas = room.getNameZonas();
			List<Zone> listZonas = new ArrayList<>();
			final Iterator<String> iterator = idZonas.iterator();
			while(iterator.hasNext()){
				String name = iterator.next();
				Zone zona = zoneService.getByName(name);
				listZonas.add(zona);
			}
			r.setZones(listZonas);
			r.setName(room.getNameRoom());
			return transform(r);
		}
	}


	@Override
	public RoomDTO getById(Integer id) throws RoomNotFoundException {
		Room r = roomDao.findOne(id);
		if(r == null)
			throw new RoomNotFoundException();
		else
			return transform(r);
	}

	@Override
	public void update(RoomDTO room) throws InvalidDataException {
		if(room == null)
			throw new InvalidDataException();
		else{
			Room r = transform(room);
			transform(roomDao.save(r));
		}
	}

	@Override
	public void delete(Integer id) throws RoomNotFoundException {
		if(roomDao.findOne(id) == null)
			throw new RoomNotFoundException();
		else
			roomDao.delete(id);
	}

	@Override
	public Room getByName(String nameRoom) {
		return roomDao.getByName(nameRoom);
	}

}
