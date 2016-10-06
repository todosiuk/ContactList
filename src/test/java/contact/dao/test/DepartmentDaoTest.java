package contact.dao.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import contact.dao.DaoException;
import contact.dao.DepartmentDaoImpl;
import contact.dao.StoreDaoImpl;
import contact.entity.Department;
import contact.entity.Store;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentDaoTest {

	@Autowired
	private StoreDaoImpl storeDao;

	@Autowired
	private DepartmentDaoImpl depDao;

	@Test
	@Transactional
	@Rollback(true)
	public void testCreateAndReadDepartment() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		Department dep = new Department(10, "hgf@ukr.net", "financier", "097-589-65-89", store);
		dep.setStore(store);
		int storeId = store.getId();
		depDao.create(storeId, dep);
		List<Department> departments = depDao.read();
		Assert.assertEquals(store.getId(), departments.get(0).getStore().getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateDaoDepartment() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		Department dep = new Department(10, "hgf@ukr.net", "financier", "097-589-65-89", store);
		dep.setStore(store);
		int storeId = store.getId();
		depDao.create(storeId, dep);
		dep.setNameDepartment(20);
		depDao.update(dep);
		List<Department> departments = depDao.read();
		Assert.assertEquals(dep.getNameDepartment(), departments.get(0).getNameDepartment());
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteDepartment() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		Department dep = new Department(10, "hgf@ukr.net", "financier", "097-589-65-89", store);
		dep.setStore(store);
		int storeId = store.getId();
		depDao.create(storeId, dep);
		depDao.delete(dep.getId());
		List<Department> departments = depDao.read();
		Assert.assertEquals(0, departments.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetDepartmentFromId() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		Department dep = new Department(10, "hgf@ukr.net", "financier", "097-589-65-89", store);
		dep.setStore(store);
		int storeId = store.getId();
		depDao.create(storeId, dep);
		Department department = depDao.getDepartmentFromId(dep.getId());
		Assert.assertEquals(department.getId(), dep.getId());
		Assert.assertEquals(department.getEmail(), dep.getEmail());
	}

}
