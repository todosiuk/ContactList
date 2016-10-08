package contact.controller.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.BDDMockito.*;
import contact.controller.StoreController;
import contact.entity.Store;
import contact.service.StoreServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml","spring-mvc-test.xml"  })
public class StoreControllerTest {

	@InjectMocks
	private StoreController storeController;

	private MockMvc mockMvc;

	@Mock
	private StoreServiceImpl storeService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(storeController).build();
		given(this.storeService.getStoreFromId(1)).willReturn(new Store("Lviv"));
	}

	@Test
	public void testGetStores() throws Exception {
		List<Store> stores = new ArrayList<>();
		stores.add(new Store());
		stores.add(new Store());

		when(storeService.read()).thenReturn(stores);

		mockMvc.perform(get("/store/stores")).andExpect(status().isOk()).andExpect(view().name("storesPage"))
				.andExpect(model().attribute("stores", hasSize(2)));
	}

	@Test
	public void testGetAdd() throws Exception {
		this.mockMvc.perform(get("/store/stores/add")).andExpect(status().isOk()).andExpect(view().name("addStorePage"))
				.andExpect(model().attributeExists("storeAttribute"));
	}

	@Test
	public void testPostAdd() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("Lviv");
		storeService.create(store);
		Mockito.verify(storeService).create(store);
		this.mockMvc.perform(post("/store/stores/add")).andExpect(status().isOk())
				.andExpect(view().name("addedStorePage"));
	}

	@Test
	public void testDelete() throws Exception {
		Integer id = 1;
		storeService.delete(id);
		Mockito.verify(storeService).delete(id);
	}

	@Test
	public void testGetUpdate() throws Exception {
		this.mockMvc.perform(get("/store/stores/edit", 1)).andExpect(status().is(400)).andExpect(view().name("editStorePage"))
		.andExpect(model().attributeExists("storeAttribute"));
	}

	@Test
	public void testUpdate() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setCity("K-1");
		storeService.create(store);
		store.setId(1);
		storeService.update(store);
		Mockito.verify(storeService).update(store);
	}

}
