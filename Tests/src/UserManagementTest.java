import dataaccess.Person;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class UserManagementTest {

    @Test
    public void LoginSuccessTest(){
        Person person = Person.login("aman", "1234");
        assertEquals("admin", person.getPersonRole().getRole());
    }

}
