package contact.dao.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateAndReadTest.class, DeleteTest.class, GetDepartmentsForStoreTest.class, GetStoreOrDepartmentFromIdTest.class,
		UpdateTest.class })
public class AllTests {

}
