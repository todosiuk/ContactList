package contact.dao.test.store;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateAndReadTest.class, DeleteTest.class, GetDepartmentsForStoreTest.class, GetStoreFromIdTest.class,
		UpdateTest.class })
public class AllTests {

}
