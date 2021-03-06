import dataaccess.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Storage;

import static org.junit.Assert.*;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class UserManagementTest {

    @Before
    public void setUp() throws Exception {
        Storage.init();
    }

    @After
    public void tearDown() throws Exception {
        Storage.persistData();
    }

    @Test
    public void LoginSuccessTest(){
        Person person = Person.login("aman", "1234");
        assertEquals("admin", person.getPersonRole().getRole());
    }

}
