package contact.controller.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import contact.controller.DepartmentController;
import contact.service.DepartmentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.*;
import contact.controller.StoreController;
import contact.entity.Department;
import contact.entity.Store;
import contact.service.StoreServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml", "spring-mvc-test.xml" })
public class DepartmentControllerTest {

	@InjectMocks
	private DepartmentController depController;

	private MockMvc mockMvc;

	@Mock
	private DepartmentServiceImpl depService;

	@Mock
	private StoreServiceImpl storeService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(depController).build();
	}

	@Test
	public void testGetAdd() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		Department department = new Department();
		department.setStore(store);

		mockMvc.perform(get("/dep/add").param("id", store.getId().toString())).andExpect(status().isOk())
				.andExpect(view().name("addDepartmentPage")).andExpect(model().attributeExists("departmentAttribute"));
	}

	@Test
	public void testPostAdd() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		Department department = new Department();
		department.setId(1);
		department.setEmail("dg@xdgij");
		department.setNameDepartment(10);
		department.setPhone("4752552556");
		department.setPost("fin");
		department.setStore(store);
		depService.create(store.getId(), department);
		Mockito.verify(depService).create(store.getId(), department);

		mockMvc.perform(post("/dep/add").param("id", store.getId().toString())).andExpect(status().isOk())
				.andExpect(view().name("addedDepartmentPage"))
				.andExpect(model().attributeExists("departmentAttribute"));
	}

	@Test
	public void testDelete() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		Department department = new Department();
		department.setId(1);
		department.setEmail("dg@xdgij");
		department.setNameDepartment(10);
		department.setPhone("4752552556");
		department.setPost("fin");
		department.setStore(store);
		depService.create(store.getId(), department);
		depService.delete(department.getId());
		Mockito.verify(depService).delete(department.getId());

		mockMvc.perform(get("/dep/delete").param("id", department.getId().toString())).andExpect(status().isOk())
				.andExpect(view().name("deletedDepartmentPage"));
	}

	@Test
	public void testGetUpdate() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		Department department = new Department();
		department.setId(1);
		department.setEmail("dg@xdgij");
		department.setNameDepartment(10);
		department.setPhone("4752552556");
		department.setPost("fin");
		department.setStore(store);
		mockMvc.perform(get("/dep/edit").param("storeId", store.getId().toString()).param("depId",
				department.getId().toString())).andExpect(status().isOk()).andExpect(view().name("editDepartmentPage"))
				.andExpect(model().attributeExists("storeId"));
	}

	@Test
	public void testPostUpdate() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		Department department = new Department();
		department.setId(1);
		department.setEmail("dg@xdgij");
		department.setNameDepartment(10);
		department.setPhone("4752552556");
		department.setPost("fin");
		department.setStore(store);
		depService.create(store.getId(), department);
		department.setNameDepartment(20);
		depService.update(department);
		Mockito.verify(depService).update(department);
		mockMvc.perform(post("/dep/edit").param("storeId", store.getId().toString()).param("depId",
				department.getId().toString())).andExpect(status().isOk()).andExpect(view().name("editedDepPage"))
				.andExpect(model().attributeExists("departmentAttribute"));
	}

}
