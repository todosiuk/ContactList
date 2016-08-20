package contact.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.Dao;
import contact.dao.DepartmentDao;
import contact.entity.Department;
import contact.entity.Store;

@Service("departmentService")
@Transactional
public class DepartmentService implements ServiceInt<Department, String> {

	@Autowired
	@Qualifier("departmentDao")
	private Dao<Department, ?> departmentDao;

	public void create(Department entity) {
		departmentDao.create(entity);
	}

	public List<Department> read() {
		return departmentDao.read();
	}

	public void update(Department entity) {
		departmentDao.update(entity);

	}

	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	public Department getDepartmentFromId(Integer id) {
		return (Department) ((DepartmentDao) departmentDao).getDepartmentFromId(id);
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dao<Department, ?> getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

}
