package com.at.library.service.zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.ZoneDao;
import com.at.library.dto.ZoneDTO;
import com.at.library.model.Zone;

@Service
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private ZoneDao zoneDao;

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
	public ZoneDTO create(ZoneDTO zone) {
		Zone z = transform(zone);
		return transform(zoneDao.save(z));
	}

	@Override
	public ZoneDTO getById(Integer id) {
		Zone z = zoneDao.findOne(id);
		return transform(z);
	}

	@Override
	public void update(ZoneDTO zone) {
		Zone z = transform(zone);
		transform(zoneDao.save(z));
	}

	@Override
	public void delete(Integer id) {
		zoneDao.delete(id);
	}

}
