package contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.StoreDao;
import contact.entity.Store;

@Service
public class StoreService implements ServiceInt<Store, String> {

	@Autowired
	private StoreDao storeDao;

	@Transactional
	public void create(Store entity) {
		storeDao.create(entity);
	}

	@Transactional
	public List<Store> read() {
		return storeDao.read();
	}

	@Transactional
	public void update(Store entity) {
		storeDao.update(entity);

	}

	@Transactional
	public void delete(Integer id) {
		storeDao.delete(id);

	}

	@Transactional
	public Store getStoreFromId(Integer id) {
		return (Store) storeDao.getStoreFromId(id);
	}

}
