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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml", "spring-mvc-test.xml" })
public class DepartmentControllerTest {

	@InjectMocks
	private DepartmentController depController;

	private MockMvc mockMvc;

	@Mock
	private DepartmentServiceImpl depService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(depController).build();
	}
	
	

}
