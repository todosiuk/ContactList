package contact.controller.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import contact.controller.StoreController;
import contact.entity.Store;
import contact.service.StoreServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

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
	}

	@Test
	public void testGetStores() throws Exception {
		List<Store> stores = new ArrayList<>();
		stores.add(new Store());
		stores.add(new Store());

		when(storeService.read()).thenReturn(stores);

		mockMvc.perform(get("/store/stores"))
		.andExpect(status().isOk()).andExpect(view().name("storesPage"))
				.andExpect(model().attribute("stores", hasSize(2)));
	}

	@Test
	public void testGetAdd() throws Exception {
		this.mockMvc.perform(get("/store/stores/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("addStorePage"))
		.andExpect(model().attributeExists("storeAttribute"));
	}
}
