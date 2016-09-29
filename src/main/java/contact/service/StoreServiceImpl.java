package contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.DaoException;
import contact.dao.StoreDao;
import contact.dao.StoreDaoImpl;
import contact.entity.Department;
import contact.entity.Store;

@Service("storeService")
@Transactional
public class StoreServiceImpl implements StoreService<Store, String> {

	@Autowired
	private StoreDao<Store, ?> storeDao;

	public void create(Store entity) throws ServiceException {
		try {
			storeDao.create(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Store> read() throws ServiceException {
		try {
			return storeDao.read();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Store entity) throws ServiceException {
		try {
			storeDao.update(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void delete(Integer id) throws ServiceException {
		try {
			storeDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Store getStoreFromId(Integer id) throws ServiceException {
		try {
			return ((StoreDaoImpl) storeDao).getStoreFromId(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Department> getDepartmentsForStore(Integer storeId) throws ServiceException {
		try {
			return storeDao.getDepartmentsForStore(storeId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
