package contact.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import contact.dao.StoreDao;
import contact.entity.Store;
import contact.service.StoreService;
import junit.framework.Assert;

@ContextConfiguration(locations = { "/dao-cfg.xml", "/data-source-hiber-cfg.xml", "/transaction-cfg.xml" })
public class StoreDaoCreateTest {

	@Autowired
	private StoreService storeService;

	@Test
	public final void testCreate() {
		Store storeTest = new Store("Kyiv", 0);
		storeService.create(storeTest);
		List<Store> store = (List<Store>) storeService.read();

	}

}
