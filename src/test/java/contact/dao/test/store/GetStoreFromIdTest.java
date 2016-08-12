package contact.dao.test.store;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.Dao;
import contact.dao.StoreDao;
import contact.entity.Store;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml", "/spring-mvc-servlet.xml" })
public class GetStoreFromIdTest {

	@Autowired
	private StoreDao storeDao;

	@Test
	public final void testGetStoreFromId() {
		Store store = new Store("Kyiv");
		storeDao.create(store);
		Integer id = store.getId();
		List<Store> storeList = (List) storeDao.getStoreFromId(id);
		assertEquals(store.getCity(), storeList.get(0).getCity());
		storeDao.delete(id);

	}
}
