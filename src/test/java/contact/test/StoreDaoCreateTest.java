package contact.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.StoreDao;
import contact.entity.Store;
import contact.service.StoreService;
import junit.framework.Assert;

@ContextConfiguration(locations = { "/dao-cfg.xml", "/data-source-hiber-cfg.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreDaoCreateTest {

	@Autowired
	private StoreDao storeDao;

	@Test
	public final void testCreate() {
		Store storeTest = new Store("Kyiv", 0);
		storeDao.create(storeTest);
		List<Store> store = storeDao.read();

	}

}
