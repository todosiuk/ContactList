package contact.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.DepartmentDao;
import contact.entity.Department;
import contact.entity.Store;

@Service
public class DepartmentService implements ServiceInt<Department, String> {

	@Autowired
	private DepartmentDao departmentDao;

	@Transactional
	public void create(Department entity) {
		departmentDao.create(entity);
	}

	@Transactional
	public List<Department> read() {
		return departmentDao.read();
	}

	@Transactional
	public void update(Department entity) {
		departmentDao.update(entity);

	}

	@Transactional
	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	@Transactional
	public Department getDepartmentFromId(Integer id) {
		return (Department) departmentDao.getDepartmentFromId(id);
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
