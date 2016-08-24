package com.at.library.service.rent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.RentDao;
import com.at.library.dto.RentDTO;
import com.at.library.model.Rent;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	private RentDao rentDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<RentDTO> findAll() {
		final Iterable<Rent> findAll = rentDao.findAll();
		final Iterator<Rent> iterator = findAll.iterator();
		final List<RentDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Rent r = iterator.next();
			final RentDTO rDTO = transform(r);
			res.add(rDTO);
		}
		return res;
	}

	@Override
	public RentDTO transform(Rent rent) {
		return dozer.map(rent, RentDTO.class);
	}

	@Override
	public Rent transform(RentDTO rent) {
		return dozer.map(rent, Rent.class);
	}

	@Override
	public RentDTO create(RentDTO rent) {
		Rent r = transform(rent);
		return transform(rentDao.save(r));
	}

	@Override
	public RentDTO getById(Integer id) {
		Rent r = rentDao.findOne(id);
		return transform(r);
	}

	@Override
	public void update(RentDTO rent) {
		Rent r = transform(rent);
		transform(rentDao.save(r));
	}

	@Override
	public void delete(Integer id) {
		rentDao.delete(id);
	}

}
