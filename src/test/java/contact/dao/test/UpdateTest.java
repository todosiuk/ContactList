package contact.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
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
public class UpdateTest {

	@Autowired
	private Dao<Store, ?> storeDao;

	@Autowired
	private Dao<Department, ?> departmentDao;

	@Test
	public final void testUpdate() {
		Store store = new Store("Kyiv");
		storeDao.create(store);
		store.setCity("Kharkiv");
		storeDao.update(store);

		Department dep = new Department(10, "dep@ukt.kj", "driver", "055-226-56-97", store);
		departmentDao.create(dep);
		dep.setPost("cleaner");
		departmentDao.update(dep);

		List<Department> depList = departmentDao.read();
		assertEquals(depList.get(0).getPost(), "cleaner");

		List<Store> storeList = storeDao.read();
		assertEquals(storeList.get(0).getCity(), "Kharkiv");

		departmentDao.delete(dep.getId());
		storeDao.delete(store.getId());

	}

}
