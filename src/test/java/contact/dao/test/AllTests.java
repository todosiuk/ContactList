package contact.dao.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import contact.controller.test.DepartmentControllerTest;
import contact.controller.test.StoreControllerTest;

@RunWith(Suite.class)
@SuiteClasses({StoreControllerTest.class, DepartmentControllerTest.class,DepartmentDaoTest.class, StoreDaoTest.class })
public class AllTests {

}
