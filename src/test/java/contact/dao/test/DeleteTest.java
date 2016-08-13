package contact.dao.test;

import static org.junit.Assert.*;
import java.util.List;
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
public class DeleteTest {

	@Autowired
	private Dao<Store, ?> storeDao;

	@Autowired
	private Dao<Department, ?> departmentDao;

	@Test
	public final void testDelete() {
		Store store = new Store("Kyiv");
		storeDao.create(store);

		Department dep = new Department(10, "dep@ukt.kj", "driver", "055-226-56-97", store);
		departmentDao.create(dep);

		departmentDao.delete(dep.getId());
		storeDao.delete(store.getId());
		List<Store> deletedStore = storeDao.read();
		List<Department> deletedDepartment = departmentDao.read();

		assertEquals(0, deletedStore.size());
		assertEquals(0, deletedDepartment.size());

	}

}
