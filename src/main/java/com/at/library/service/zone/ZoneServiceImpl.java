package com.at.library.service.zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.ZoneDao;
import com.at.library.dto.ZoneDTO;
import com.at.library.dto.ZonePostDTO;
import com.at.library.exception.BookNotFoundException;
import com.at.library.exception.InvalidDataException;
import com.at.library.exception.ZoneNotFoundException;
import com.at.library.model.Book;
import com.at.library.model.Zone;
import com.at.library.service.book.BookService;
import com.at.library.service.room.RoomService;

@Service
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private ZoneDao zoneDao;

	@Autowired
	private BookService bookService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<ZoneDTO> findAll() {
		final Iterable<Zone> findAll = zoneDao.findAll();
		final Iterator<Zone> iterator = findAll.iterator();
		final List<ZoneDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Zone z = iterator.next();
			final ZoneDTO zDTO = transform(z);
			res.add(zDTO);
		}
		return res;
	}

	@Override
	public ZoneDTO transform(Zone zone) {
		return dozer.map(zone, ZoneDTO.class);
	}

	@Override
	public Zone transform(ZoneDTO rent) {
		return dozer.map(rent, Zone.class);
	}
	

	@Override
	public ZoneDTO create(ZonePostDTO zone) throws BookNotFoundException, InvalidDataException {

		if(zone == null){
			throw new InvalidDataException();
		}
		else{
			Zone z = new Zone();
			List<Integer> idLibros = zone.getIdLibros();
			List<Book> listLibros = new ArrayList<>();
			final Iterator<Integer> iterator = idLibros.iterator();
			while(iterator.hasNext()){
				Integer i = iterator.next();
				Book b = bookService.getById(i);
				listLibros.add(b);
			}
			z.setBooks(listLibros);
			z.setRoom(roomService.getByName(zone.getNameRoom()));
			z.setName(zone.getNameRoom()+zone.getNameZone());
			return transform(z);
		}
	}

	@Override
	public ZoneDTO getById(Integer id) throws ZoneNotFoundException {
		Zone z = zoneDao.findOne(id);
		if(z == null)
			throw new ZoneNotFoundException();
		else
			return transform(z);
	}

	@Override
	public void update(ZoneDTO zone) throws InvalidDataException {
		if(zone == null)
			throw new InvalidDataException();
		else{
			Zone z = transform(zone);
			transform(zoneDao.save(z));
		}
	}

	@Override
	public void delete(Integer id) throws ZoneNotFoundException {
		if(zoneDao.findOne(id) == null)
			throw new ZoneNotFoundException();
		else
			zoneDao.delete(id);
	}

	@Override
	public Zone getByName(String name) throws ZoneNotFoundException {
		Zone z = zoneDao.getByName(name);
		if(z == null)
			throw new ZoneNotFoundException();
		else
			return z;
	}

}
