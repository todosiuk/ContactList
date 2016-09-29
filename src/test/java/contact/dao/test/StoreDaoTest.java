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
import contact.dao.StoreDaoImpl;
import contact.entity.Store;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreDaoTest {

	@Autowired
	private StoreDaoImpl storeDao;

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
	
	

}
