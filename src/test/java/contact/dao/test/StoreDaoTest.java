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
public class StoreDaoTest {

	@Autowired
	private StoreDaoImpl storeDao;

	@Autowired
	private DepartmentDaoImpl depDao;

	@Test
	@Transactional
	@Rollback(true)
	public void testCreateAndReadStore() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		List<Store> stores = storeDao.read();
		Assert.assertEquals(store.getCity(), stores.get(0).getCity());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateStore() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		store.setCity("London");
		storeDao.update(store);
		List<Store> stores = storeDao.read();
		Assert.assertEquals("London", stores.get(0).getCity());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteStore() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		storeDao.delete(store.getId());
		List<Store> stores = storeDao.read();
		Assert.assertEquals(0, stores.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetStoreFromId() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		List<Store> stores = storeDao.read();
		storeDao.getStoreFromId(store.getId());
		Assert.assertEquals(store.getId(), stores.get(0).getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetDepartmentsForStore() throws DaoException {
		Store store = new Store("K-1");
		storeDao.create(store);
		Department department = new Department(10, "hgf@ukr.net", "financier", "097-589-65-89", store);
		int storeId = store.getId();
		depDao.create(storeId, department);
		List<Department> depForStore = storeDao.getDepartmentsForStore(storeId);
		Assert.assertEquals(store.getId(), depForStore.get(0).getStore().getId());
	}

}
