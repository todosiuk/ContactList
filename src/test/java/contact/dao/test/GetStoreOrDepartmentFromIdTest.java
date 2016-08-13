package contact.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.dao.Dao;
import contact.dao.DepartmentDao;
import contact.dao.StoreDao;
import contact.entity.Department;
import contact.entity.Store;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml", "/spring-mvc-servlet.xml" })
public class GetStoreOrDepartmentFromIdTest {

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Test
	public final void testGetStoreOrDepartmentFromId() {
		Store store = new Store("Kyiv");
		storeDao.create(store);

		Department dep = new Department(10, "dep@ukt.kj", "driver", "055-226-56-97", store);
		departmentDao.create(dep);

		List<Store> storeList = (List) storeDao.getStoreFromId(store.getId());
		assertEquals(store.getCity(), storeList.get(0).getCity());

		List<Department> depList = (List<Department>) departmentDao.getDepartmentFromId(dep.getId());
		assertEquals(dep.getEmail(), depList.get(0).getEmail());

		departmentDao.delete(dep.getId());
		storeDao.delete(store.getId());

	}
}
