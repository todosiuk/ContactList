package contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.StoreDao;
import contact.dao.DepartmentDaoImpl;
import contact.dao.DepartmentDao;
import contact.entity.Department;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService<Department, String> {

	@Autowired
	private DepartmentDao<Department, ?> departmentDao;

	public void create(Integer storeId, Department entity) {
		departmentDao.create(storeId, entity);
	}

	public List<Department> read(Integer id) {
		return departmentDao.read();
	}

	public void update(Department entity) {
		departmentDao.update(entity);

	}

	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	public Department getDepartmentFromId(Integer id) {
		return (Department) ((DepartmentDaoImpl) departmentDao).getDepartmentFromId(id);
	}

	public StoreDao<Department, ?> getDepartmentDao() {
		return (StoreDao<Department, ?>) departmentDao;
	}

	public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
		this.departmentDao = departmentDao;
	}

}
