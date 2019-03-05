import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Storage;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class StorageTest {

    @Before
    public void setUp() throws Exception {
        Storage.init();
    }

    @After
    public void tearDown() throws Exception {
        Storage.persistData();
    }

    @Test
    public void persistenceTest() {

    }

}
