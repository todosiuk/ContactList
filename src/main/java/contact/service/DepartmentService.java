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
@Transactional
public class DepartmentService implements ServiceInt<Department, String> {

	@Autowired
	private DepartmentDao departmentDao;

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
		return (Department) departmentDao.getDepartmentFromId(id);
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
