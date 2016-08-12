package contact.dao.test.store;

import static org.junit.Assert.*;

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
public class GetDepartmentsForStoreTest {

	@Autowired
	private Dao<Store,?> storeDao;
	
	@Autowired
	private Dao<Department, ?> departmentDao;
	
	@Test
	public final void testGetDepartmentsForStore() {
		Store store = new Store("Toronto");
		storeDao.create(store);
		Department department = new Department(10, "dep@ukr.net", "financier", "066-58-965-84", store);
		departmentDao.create(department);
		
		assertEquals(store.getId(), department.getStore().getId());
		
		Integer id = store.getId();
		Integer idDep = department.getId();
		departmentDao.delete(idDep);
		storeDao.delete(id);
	}
	

}
