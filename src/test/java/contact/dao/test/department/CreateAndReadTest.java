package contact.dao.test.department;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.Dao;
import contact.entity.Department;
import contact.entity.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml", "/spring-mvc-servlet.xml" })
public class CreateAndReadTest {

	@Autowired
	private Dao<Department, ?> departmentDao;

	@Autowired
	private Dao<Store, ?> storeDao;

	@Test
	public final void testCreateAndRead() {
		Store store = new Store("New York");
		storeDao.create(store);

		Department dep = new Department(10, "dep@ukt.kj", "driver", "055-226-56-97", store);
		departmentDao.create(dep);

		assertEquals(store.getId(), dep.getStore().getId());
		assertEquals("driver", dep.getPost());
		assertEquals("dep@ukt.kj", dep.getEmail());
		assertEquals("055-226-56-97", dep.getPhone());

		Integer idStore = store.getId();
		Integer idDep = dep.getId();

		departmentDao.delete(idDep);
		storeDao.delete(idStore);

	}

}
