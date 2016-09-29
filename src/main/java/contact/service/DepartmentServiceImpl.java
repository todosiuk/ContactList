package contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.StoreDao;
import contact.dao.DepartmentDaoImpl;
import contact.dao.DaoException;
import contact.dao.DepartmentDao;
import contact.entity.Department;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService<Department, String> {

	@Autowired
	private DepartmentDao<Department, ?> departmentDao;

	public void create(Integer storeId, Department entity) throws ServiceException {
		try {
			departmentDao.create(storeId, entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Department> read(Integer id) throws ServiceException {
		try {
			return departmentDao.read();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Department entity) throws ServiceException {
		try {
			departmentDao.update(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void delete(Integer id) throws ServiceException {
		try {
			departmentDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public Department getDepartmentFromId(Integer id) throws ServiceException {
		try {
			return (Department) ((DepartmentDaoImpl) departmentDao).getDepartmentFromId(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public StoreDao<Department, ?> getDepartmentDao() {
		return (StoreDao<Department, ?>) departmentDao;
	}

	public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
		this.departmentDao = departmentDao;
	}

}
