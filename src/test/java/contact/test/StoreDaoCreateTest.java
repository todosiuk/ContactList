package contact.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.Dao;
import contact.entity.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml", "/spring-mvc-servlet.xml" })
public class StoreDaoCreateTest {

	@Autowired
	private Dao<Store, ?> storeDao;

	@Test
	public final void testCreate() {
		Store storeTest = new Store("Kyiv", 1);
		storeDao.create(storeTest);
		List<Store> store = storeDao.read();
		Assert.assertEquals(storeTest.getCity(), store.get(1).getCity());

	}

}
