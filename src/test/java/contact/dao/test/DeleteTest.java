package contact.dao.test.store;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.Dao;
import contact.entity.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml", "/spring-mvc-servlet.xml" })
public class DeleteTest {

	@Autowired
	private Dao<Store, ?> storeDao;

	@Test
	public final void testDelete() {
		Store store = new Store("Kyiv");
		storeDao.create(store);
		Integer id = store.getId();
		storeDao.delete(id);
		List<Store> deletedStore = storeDao.read();
		assertEquals(0, deletedStore.size());

	}

}
