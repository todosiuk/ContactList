package contact.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import contact.entity.Department;
import contact.entity.Store;
import contact.service.DepartmentService;
import contact.service.ServiceInt;
import contact.service.StoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-source-hiber-cfg.xml"})
public class CreateAndReadTest {

	@Autowired
	@Qualifier(value="storeService")
	private StoreService storeService;

	@Autowired
	@Qualifier(value="departmentService")
	private DepartmentService departmentService;
	
	@Test
	public final void testCreateAndRead() {
		Store store = new Store("Kyiv");
		storeService.create(store);
		
		Department dep = new Department(10, "dep@ukt.kj", "driver", "055-226-56-97", store);
		departmentService.create(dep);

		assertNotNull(store);
		assertNotNull(dep);

		List<Store> storeList = storeService.read();
		List<Department> depList = departmentService.read();

		assertNotNull(depList);
		assertNotNull(storeList);

		departmentService.delete(dep.getId());
		storeService.delete(store.getId());

	}

}
