package contact.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.Dao;
import contact.dao.StoreDao;
import contact.entity.Store;


@Service("storeService")
@Transactional
public class StoreService implements ServiceInt<Store, String> {

	@Autowired
	@Qualifier("storeDao")
	private Dao<Store, ?> storeDao;

	public void create(Store entity) {
		storeDao.create(entity);
	}

	public List<Store> read() {
		return storeDao.read();
	}

	public void update(Store entity) {
		storeDao.update(entity);

	}

	public void delete(Integer id) {
		storeDao.delete(id);

	}

	public Store getStoreFromId(Integer id) {
		return (Store) ((StoreDao) storeDao).getStoreFromId(id);
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return storeDao.getDepartmentsForStore(store);
	}

}
